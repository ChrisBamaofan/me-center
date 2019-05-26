package com.me;

import com.me.auth.annotation.EnableAuthentication;
import com.me.spring.web.handler.annotation.EnableMorphedResponse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * 启动类
 * @SpringBootApplication 标记后
 * @author zhaohaojie
 * @date 2018-12-29 11:47
 */
@SpringBootApplication//标记为是一个spring boot启动类
@EnableAuthentication//使用登陆身份认证
@EnableMorphedResponse//启动统一格式返回拦截器
@EnableCaching//启动缓存
@MapperScan(basePackages = "com.me.mysql.mapper")//整合mybatis扫描mapper接口到bean容器
@EnableEurekaClient
public class Application {

    public static void main(String[] args) {
        //获取调用栈的数组，并且获取对应的方法和类名，获取的方式应该就是将this传入，获取的方式就是通过回调函数
//        StackTraceElement[] element = (new RuntimeException()).getStackTrace();
//        element[0].getMethodName();
        SpringApplication.run(Application.class,args);
    }
}

