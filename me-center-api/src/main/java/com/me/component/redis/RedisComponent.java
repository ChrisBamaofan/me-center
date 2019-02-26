package com.me.component.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * redis 工具类
 * @author zhaohaojie
 * @date 2019-02-25 15:14
 */
@Component
public class RedisComponent {

    @Autowired
    private StringRedisTemplate stringTemplate;

    public void setString(String key,String value){

    }

    public String getStringData(String key){
        if (StringUtils.isEmpty(key)){
            throw new RedisException("调用redis异常，key不能为空。",-1);
        }
        return stringTemplate.opsForValue().get(key);
    }

    public void setHashData(String key,Map mapo){
        if (StringUtils.isEmpty(key)){
            throw new RedisException("调用redis异常，key不能为空。",-1);
        }
        for (Object o : mapo.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            stringTemplate.opsForHash().put(key, entry.getKey(), entry.getValue());
        }
    }

    public Map getHashData(String key){
        if (StringUtils.isEmpty(key)){
            throw new RedisException("调用redis异常，key不能为空。",-1);
        }
        return stringTemplate.opsForHash().entries(key);
    }

    public boolean hasKey(String key,String key2){
        if (StringUtils.isEmpty(key)||StringUtils.isEmpty(key2)){
            throw new RedisException("调用redis异常，key不能为空。",-1);
        }
        return stringTemplate.opsForHash().hasKey(key,key2);
    }

    public long removeHashKey(String key,String key2){
//        stringTemplate.delete(key);
        return stringTemplate.opsForHash().delete(key,key2);
    }

}

