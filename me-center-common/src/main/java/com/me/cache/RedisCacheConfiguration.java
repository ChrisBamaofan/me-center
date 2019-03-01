package com.me.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

/**
 * redis缓存管理器
 * @author zhaohaojie
 * @date 2019-02-25 23:41
 */
@Configuration
@EnableCaching
@EnableConfigurationProperties(value = CacheProperties.class)
public class RedisCacheConfiguration extends CachingConfigurerSupport {

    public static final String RedisCacheManager = "redisCacheManager";

    /**
     * 调用spring源生配置缓存的 prefix
     */
    @Autowired
    private CacheProperties cacheProperties;

    //redis管理bean
    @Primary
    @Bean(RedisCacheManager)
    public CacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置value的序列化器
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setUsePrefix(true);
        cacheManager.setExpires(RedisCacheExpire.mapValues());
        List<String> cacheNames = cacheProperties.getCacheNames();
        for (RedisCacheExpire expire: RedisCacheExpire.values()){
            cacheNames.add(expire.getCacheName());
        }
        if (cacheNames.size()>0){
            cacheManager.setCacheNames(cacheNames);
        }
        return cacheManager;
    }
}

