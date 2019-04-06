package com.me.configuration.MQConfigs;

import lombok.Data;
import org.apache.activemq.ScheduledMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jms.core.MessagePostProcessor;

import javax.jms.JMSException;
import javax.jms.Message;

/**
 * MQ延时投递处理器（注：ActiveMQ的activemq.xml配置文件中，要配置schedulerSupport="true"，否则不起作用）
 * @author zhaohaojie
 * @date 2019-04-02 17:15
 */
@Data
public class ScheduleMessagePostProcessor implements MessagePostProcessor {

    private long delay =0;

    private String corn = null;

    public ScheduleMessagePostProcessor(long delay) {
        this.delay = delay;
    }

    public ScheduleMessagePostProcessor(String cron) {
        this.corn = cron;
    }

    @Override
    public Message postProcessMessage(Message message) throws JMSException {
        if (delay > 0) {
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
        }

        if (!StringUtils.isEmpty(corn)) {
            message.setStringProperty(ScheduledMessage.AMQ_SCHEDULED_CRON, corn);
        }
        return message;
    }
}

