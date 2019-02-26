package com.me.cache.annotation;

import com.me.cache.RedisConfiguration;
import com.me.cache.RedisKey;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Inherited
@Documented
@CachePut(value = RedisKey.PreFixKey,cacheManager = RedisConfiguration.RedisCacheManager)
public @interface RedisCachePut {

    /**
     * Alias for {@link CachePut#value()}.
     */
    @AliasFor(annotation = CachePut.class)
    String[] value() default {};

    /**
     * Alias for {@link CachePut#cacheNames()}.
     */
    @AliasFor(annotation = CachePut.class)
    String[] cacheNames() default {};

    /**
     * Alias for {@link CachePut#key()}.
     */
    @AliasFor(annotation = CachePut.class)
    String key() default "";

    /**
     * Alias for {@link CachePut#keyGenerator()}.
     */
    @AliasFor(annotation = CachePut.class)
    String keyGenerator() default "";

    /**
     * Alias for {@link CachePut#cacheResolver()}.
     */
    @AliasFor(annotation = CachePut.class)
    String cacheResolver() default "";

    /**
     * Alias for {@link CachePut#condition()}.
     */
    @AliasFor(annotation = CachePut.class)
    String condition() default "";

    /**
     * Alias for {@link CachePut#unless()}.
     */
    @AliasFor(annotation = CachePut.class)
    String unless() default "";

}
