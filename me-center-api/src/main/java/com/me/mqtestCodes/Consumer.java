package com.me.mqtestCodes;

import com.me.configuration.MQConfigs.MessageModel;
import com.me.exception.SeckillException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author zhaohaojie
 * @date 2019-03-31 16:51
 */
@Component
@Slf4j
public class Consumer {

    @JmsListener(destination = "queue1", containerFactory = "jmsQueueListener")
    public void receiveQueue(final TextMessage text, Session session)
            throws JMSException {
        try {
            log.debug("Consumer收到的报文为:" + text.getText());
//            throw new SeckillException("",-1);
            text.acknowledge();// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
        } catch (Exception e) {
            session.recover();// 此不可省略 重发信息使用
        }
    }

    @JmsListener(destination = "queue2", containerFactory = "jmsQueueListener")
    public void receiveQueue2(final TextMessage text, Session session)
            throws JMSException {
        try {
            log.debug("DelayConsumer 收到的报文为:" + text.getJMSMessageID()+") text is "+text.getText()+",text.getJMSCorrelationID()"+text.getJMSCorrelationID()+",text.getJMSCorrelationID()="+text.getJMSCorrelationID()
            +",text.getJMSType()"+text.getJMSType()+",text.getJMSDeliveryMode()"+text.getJMSDeliveryMode()+",text.getJMSDestination()+"+text.getJMSDestination()+",text.getJMSExpiration()"+text.getJMSExpiration()+",text.getJMSPriority()"+text.getJMSPriority()+",text.getJMSRedelivered()"+text.getJMSRedelivered()
            +",text.getJMSReplyTo()"+text.getJMSReplyTo()+",text.getJMSTimestamp()"+text.getJMSTimestamp());
//            throw new SeckillException("",-1);
        text.acknowledge();
            session.getAcknowledgeMode();// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
        } catch (Exception e) {
            session.recover();// 此不可省略 重发信息使用
        }
    }

}

