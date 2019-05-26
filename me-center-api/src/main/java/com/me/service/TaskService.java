package com.me.service;

import com.me.exception.TaskAnnoException;
import com.me.taskConfig.EcTask;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 异步任务
 * @author zhaohaojie
 * @date 2019-04-18 20:59
 */
@Slf4j
public class TaskService {

    private static HashMap<String, EcTask> taskMap = new HashMap<>();

    public static void register(Method method, Object object,String code){
        if (taskMap==null){
            taskMap  = new HashMap<>();
        }
        log.info("开始注册服务 [serviceCode] : "+code);
        if (taskMap.containsKey(code)){
            throw new TaskAnnoException("重复注册服务["+code+"]",-1);
        }

    }
}

