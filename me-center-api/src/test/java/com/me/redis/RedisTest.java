package com.me.redis;

import com.me.mysql.domain.SeckillSuccess;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Tuple;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaohaojie
 * @date 2019-02-25 16:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisOps redisOps;

    @Test
    public void redisDataTest(){
        // hput
        redisTemplate.opsForHash().put("wuxia","tianlongbabu","ceshi test");
        redisOps.expireKey("wuxia",20, TimeUnit.SECONDS);
        SeckillSuccess success = new SeckillSuccess();
        success.setPid(1212);
        success.setCreateTime(LocalDateTime.now());
        success.setProductId(1001);
        success.setPhoneNumber("15026969417");
        success.setStatus(-1);

        redisTemplate.opsForValue().set("succell",success,10000,TimeUnit.MILLISECONDS);
        SeckillSuccess value = (SeckillSuccess)redisTemplate.opsForValue().get("succell");
        redisOps.expireKey("succell",5,TimeUnit.SECONDS);
        log.debug("value "+value);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String value2 = (String)redisTemplate.opsForValue().get("succell");
        log.debug("value "+value2);
    }

    @Test
    public void testList(){
        SeckillSuccess success = new SeckillSuccess();
        success.setPid(1212);
        success.setCreateTime(LocalDateTime.now());
        success.setProductId(1001);
        success.setPhoneNumber("15026969417");
        success.setStatus(-1);

        redisTemplate.opsForList().leftPush("suc",success);
        success.setPid(12);
        success.setProductId(1111);
        redisTemplate.opsForList().leftPush("suc2",success);
        SeckillSuccess sc= (SeckillSuccess) redisTemplate.opsForList().rightPop("suc");
        SeckillSuccess sc2= (SeckillSuccess) redisTemplate.opsForList().leftPop("suc2");
        System.out.println(sc.toString());
        System.out.println(sc2.toString());
    }

    @Test
    public void testSet(){
        SeckillSuccess success = new SeckillSuccess();
        success.setPid(1212);
        success.setCreateTime(LocalDateTime.now());
        success.setProductId(1001);
        success.setPhoneNumber("15026969417");
        success.setStatus(-1);

        SeckillSuccess success2 = new SeckillSuccess();
        success2.setPid(1212);
        success2.setCreateTime(LocalDateTime.now());
        success2.setProductId(1001);
        success2.setPhoneNumber("15026969417");
        success2.setStatus(-1);

        redisTemplate.opsForSet().add("seckill",success,success2);

        System.out.println(redisTemplate.opsForSet().members("seckill"));
    }

    @Test
    public void testZSet(){
        String key  ="score of math";
        ZSetOperations zop = redisTemplate.opsForZSet();
        zop.add(key,"robben",22);
        zop.add(key,"joth",30);
        zop.add(key,"ranck",81);

        zop.add(key,"ben",80);
        zop.add(key,"jack",95);
        zop.add(key,"alice",99);
//        Set<ZSetOperations.TypedTuple> sets = zop.rangeWithScores(key,0,-1);
//        for (ZSetOperations.TypedTuple tp : sets){
//            System.out.println(tp.getValue()+" scored "+tp.getScore());
//        }

        Set<String> sets = zop.reverseRangeByScore(key,0,100);
        Set<String> set2 = zop.reverseRange(key,0,100);
        Set<ZSetOperations.TypedTuple> set3  =zop.reverseRangeByScoreWithScores(key,0,100);
        for (String tp : sets){
//            System.out.println(tp.getValue()+" scored "+tp.getScore());
        }
    }
}

