package com.me.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaohaojie
 * @date 2019-02-26 11:03
 */
public enum RedisCacheExpire {

    UserInfo(RedisCacheKey.UserInfo,3600L);

    private String cacheName;
    private Long expireTime;

    RedisCacheExpire(String cacheName, Long expireTime){
        this.cacheName = cacheName;
        this.expireTime = expireTime;
    }

    public static Map<String,Long> mapValues(){
        Map<String,Long> expires = new HashMap<String, Long>();
        for (RedisCacheExpire expire:values()){
            expires.put(expire.cacheName,expire.expireTime);
        }
        return expires;
    }

    public String getCacheName() {
        return cacheName;
    }

    public Long getExpireTime() {
        return expireTime;
    }
}
