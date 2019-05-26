package com.me.controller;

import com.me.auth.annotation.AuthenticationParam;
import com.me.mysql.domain.UserInfo;
import com.me.service.UserInfoService;
import com.me.spring.web.handler.annotation.MorphedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;


/**
 * login controller
 *
 * @author zhaohaojie
 * @date 2018-12-29 14:15
 */
@RestController
@MorphedResponse
@RequestMapping(value = "/me/center")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Jackson2ObjectMapperBuilder builder;
    @GetMapping("/login/{id}")
//    @SkipAuthentication
    public UserInfo login(@PathVariable("id") Integer id, @AuthenticationParam String value){
        return userInfoService.getUserInfo(id);
    }

    @PostMapping("/update/userinfo")
    public void updateUserInfo(@RequestBody UserInfo userInfo){
        userInfoService.updateUserInfo(userInfo);
    }

}

