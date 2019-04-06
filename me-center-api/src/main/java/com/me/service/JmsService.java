package com.me.service;

import cn.hutool.core.date.DateUtil;
import com.me.configuration.MQConfigs.MessageModel;
import com.me.exception.MQException;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ScheduledMessage;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 消息服务
 *1.activeMQ的管理以及测试
 * @author zhaohaojie
 * @date 2019-03-14 23:21
 */
@Service
@Slf4j
@EnableScheduling //TODO 启动定时任务
public class JmsService {

    @Resource(name = "Template1")
    private JmsTemplate jmsTemplate;


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
    @Scheduled(cron = "*/15 * * * * ?")
    public void delaySendMessage(){
        for (int i=0;i<1;i++){
            String str = "message "+DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
                System.out.println( DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss")+" send to quque "+str);
                delaySend(new ActiveMQQueue("queue2"), str, 6000L);
        }
    }


    public  void delaySend(Destination destination, String data, Long time){
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        // 获取连接工厂
        ConnectionFactory connectionFactory = jmsTemplate.getConnectionFactory();
        try {
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
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, time);
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

