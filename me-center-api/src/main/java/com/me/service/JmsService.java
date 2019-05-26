package com.me.service;

import cn.hutool.core.date.DateUtil;
import com.me.exception.MQException;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ScheduledMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.*;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 消息服务
 *1.activeMQ的管理以及测试
 * @author zhaohaojie
 * @date 2019-03-14 23:21
 */
@Service
@Slf4j
@EnableScheduling
public class JmsService {

    @Resource(name = "Template1")
    private JmsTemplate jmsTemplate;

    @Value("${file.path}")
    String path;

    private static int count=-1;
    /**
     * 发送消息
     * @param destination 目的端
     * @param msg 消息体
     * @param delayTime 延迟投递消息
     */
    public void sendMessage(String destination, String msg,Long delayTime){

        if (StringUtils.isEmpty(msg)){
            throw new MQException("不能为空").set("mq destination id = ",destination);
        }

        Destination des = new ActiveMQQueue(destination);
        jmsTemplate.convertAndSend(destination,msg);
    }

//    @Scheduled(cron = "0/5 * * * * ?")
    public void sendMessage(){
        Object message1 = "corn消息内容：" + System.currentTimeMillis();
        for (int i=0;i<3;i++){
            try {
                ActiveMQTextMessage message = new ActiveMQTextMessage();
                message.setText("测试消息" +i);
                Destination destination = new ActiveMQQueue("queue1");
                String date = DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss").toString();
                System.out.println( date+"send to quque"+message.getText());
                jmsTemplate.convertAndSend("queue1",message);
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 定时任务
     * 每8秒
     */
//    @Scheduled(cron = "*/8 * * * * ?")
    public void delaySendMessage(){
        for (int i=0;i<1;i++){
            String str = "message "+DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
                System.out.println( DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss")+" send to quque "+str);
                delaySend(new ActiveMQQueue("queue2"), str, 0L);
        }
    }

    /**
     * 每分钟将log文件移动到指定的MQ中
     */
//    @Scheduled(cron = "*/30 * * * * ?")
    public void removeLogFilesByMq() throws IOException {
        count++;
        File file = new File(path);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[1024<<2];
            int size=-1;
            log.debug(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss")+"start remove!");
            int sizeIncrease=0;
            while((size = inputStream.read(buffer))!= -1){
                log.debug("count is "+count+" ,this is "+(++sizeIncrease)+"th send message,");
                jmsTemplate.send(new ActiveMQQueue("logQueue"), new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        TextMessage message = null;
                        try {
                            message = session.createTextMessage(new String(buffer,"UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        return message;
                    }
                });
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
            file.renameTo(new File("E:/rename.txt"));

        }
    }


    public  void delaySend(Destination destination, String data, Long time){
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        // 获取连接工厂
        ConnectionFactory connectionFactory = jmsTemplate.getConnectionFactory();
        try {
            ConcurrentHashMap map  = new ConcurrentHashMap();
            map.put(null,null);
            // 获取连接
            connection = connectionFactory.createConnection();
            connection.start();
            // 获取session，true开启事务，false关闭事务
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建一个消息队列
            producer = session.createProducer(destination);
            producer.setDeliveryMode(JmsProperties.DeliveryMode.PERSISTENT.getValue());
            TextMessage message = session.createTextMessage(data);// 五种类型的消息
            //设置延迟时间
//            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, time);
            message.setStringProperty("headname","i am test"+data);
            // 发送消息
            producer.send(message);
            session.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (producer != null){
                    producer.close();
                }
                if (session != null){
                    session.close();
                }
                if (connection != null){
                    connection.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

