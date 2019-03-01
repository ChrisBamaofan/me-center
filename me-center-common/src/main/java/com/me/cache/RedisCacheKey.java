package com.me.cache;

import org.springframework.stereotype.Component;

/**
 * 配置redisCache的名称
 *
 * @author zhaohaojie
 * @date 2019-02-25 22:58
 */
@Component
public class RedisCacheKey {

    public final static String PreFixKey = "Com.Me.";

    public final static String UserInfo = PreFixKey+"UserInfo";

}

