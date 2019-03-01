package com.me.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaohaojie
 * @date 2019-02-25 16:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

    @Autowired
    private MyRedisTemplate redisTemplate;

    @Test
    public void redisDataTest(){
        redisTemplate.hset("wuxia","tianlongbabu","123");
        String value = redisTemplate.hget("wuxia","tianlongbabu");
        redisTemplate.expire("wuxia",20);
        log.debug("value "+value);
    }
}

