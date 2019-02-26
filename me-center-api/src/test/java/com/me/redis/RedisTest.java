package com.me.redis;

import com.me.component.redis.RedisComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaohaojie
 * @date 2019-02-25 16:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

    @Autowired
    private RedisComponent redisComponent;

    @Test
    public void redisDataTest(){
        Map map = new HashMap();
        map.put("r1","不是很好看");
        map.put("e1","很值得观看的电影");
        redisComponent.setHashData("wuxia",map);
        Map mapo = redisComponent.getHashData("wuxia");
        for (Object m:mapo.entrySet()){
            Map.Entry mo = (Map.Entry)m;
            log.debug(mo.getKey()+","+mo.getValue());
        }

        log.debug("has mapo'武侠'天龙八部' key "+redisComponent.hasKey("wuxia","r1"));
//        log.debug("redisComponent.removeHashKey(\"天龙八部2\") is "+redisComponent.removeHashKey("wuxia","e1"));
//        log.debug("redisComponent.removeHashKey(\"天龙八部\") is "+redisComponent.removeHashKey("wuxia","r1"));
    }
}

