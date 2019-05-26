package com.me.aop.cglib;

import com.me.service.SeckillService;
import com.me.service.TaskService;
import com.me.taskConfig.TaskAnno;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author zhaohaojie
 * @date 2019-04-18 20:56
 */
@Slf4j
public class CglibInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //在执行具体的方法前判断该方法是否含有某些注解如果含有注解则做对应的注解注册
        TaskAnno annotations  = method.getAnnotation(TaskAnno.class);
        log.debug("动态代理MethodInterceptor...");
        if (annotations != null){
            log.debug("存在TaskAnno...Object :"+o+",method : "+method.getName()+",MethodProxy : "+methodProxy);
            TaskService.register(method,o,annotations.value());
        }
        Object object = methodProxy.invokeSuper(o,objects);
        log.debug("methodProxy.invokeSuper(o,objects) result is "+object);
        return object;
    }

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        CglibInterceptor interceptor = new CglibInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SeckillService.class);
        enhancer.setCallback(interceptor);
        SeckillService seckillService = (SeckillService) enhancer.create();
        seckillService.getMD5(15026969417L);

    }
}

