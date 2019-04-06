package com.me.activemq;

import com.me.service.JmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 * @author zhaohaojie
 * @date 2019-03-15 10:12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MQTest {
    @Autowired
    private JmsService service;
    @Test
    public void test(){
        for (int i=0;i<10;i++){
            service.sendMessage("queue","heieheihe"+i,500L);
        }
    }

    public void receive(){
//        service.reveiveMessage()
    }

}

