package com.me.controller;

import com.me.spring.web.handler.annotation.MorphedResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohaojie
 * @date 2019-04-10 21:25
 */
@RestController
@MorphedResponse
public class HelloController {
    @RequestMapping("/")
    public  String hello(){
        return  "hello KinY ~KoKo";
    }
}

