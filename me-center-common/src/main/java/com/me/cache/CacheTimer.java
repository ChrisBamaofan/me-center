package com.me.cache;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author zhaohaojie
 * @date 2019-04-21 0:24
 */
@EnableScheduling
@Component
public class CacheTimer extends TimerTask {
    public static HashMap<String,Object> platServiceMap = new HashMap<>();

    public Timer time = null;

    //fixDelay上一次执行完毕之后每隔多久执行一次，单位ms,//fixRate上一次执行开始之后每隔多久执行一次
    @Scheduled(cron = "*/30 * * * * ?",fixedDelay = -1L)
    public void init(){
        time = new Timer("定时加载缓存配置信息",true);
        time.schedule(new CacheTimer(),100,60000L);
        run();
    }
    @Override
    public void run() {
        //从数据库读取接口配置信息 List 并缓存到静态map中
        //判空list
        //TODO 接口表，接口名，接口类型，接口是否生效，接口创建时间，接口开关，评价
    }
}

