package com.me.mqtestCodes;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohaojie
 * @date 2019-03-31 16:45
 */
@RestController
public class TestController {
    /*
     * 监听和读取消息
     */
    @JmsListener(destination="active.topic")
    public void readActiveTopic(String message) {
        System.out.println("接受到2：" + message);
        //TODO something
    }
}

