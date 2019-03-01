package com.me.cache.annotation;

import com.me.cache.RedisCacheConfiguration;
import com.me.cache.RedisCacheKey;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Inherited
@Documented
@Cacheable(cacheNames = RedisCacheKey.PreFixKey,cacheManager = RedisCacheConfiguration.RedisCacheManager)
public @interface RedisCacheable {

    /**
     * Alias for {@link Cacheable#value()}.
     */
    @AliasFor(annotation = Cacheable.class)
    String[] value() default {};

    /**
     * Alias for {@link Cacheable#cacheNames()}.
     */
    @AliasFor(annotation = Cacheable.class)
    String[] cacheNames() default {};

    /**
     * Alias for {@link Cacheable#key()}.
     */
    @AliasFor(annotation = Cacheable.class)
    String key() default "";

    /**
     * Alias for {@link Cacheable#keyGenerator()}.
     */
    @AliasFor(annotation = Cacheable.class)
    String keyGenerator() default "";

    /**
     * Alias for {@link Cacheable#cacheResolver()}.
     */
    @AliasFor(annotation = Cacheable.class)
    String cacheResolver() default "";

    /**
     * Alias for {@link Cacheable#condition()}.
     */
    @AliasFor(annotation = Cacheable.class)
    String condition() default "";

    /**
     * Alias for {@link Cacheable#unless()}.
     */
    @AliasFor(annotation = Cacheable.class)
    String unless() default "";

    /**
     * Alias for {@link Cacheable#sync()}.
     */
    @AliasFor(annotation = Cacheable.class)
    boolean sync() default false;
}
