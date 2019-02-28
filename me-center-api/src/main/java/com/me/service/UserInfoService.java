package com.me.service;

import com.alibaba.fastjson.JSONObject;
import com.me.cache.RedisKey;
import com.me.cache.annotation.RedisCachePut;
import com.me.cache.annotation.RedisCacheable;
import com.me.mysql.domain.UserInfo;
import com.me.mysql.domain.UserInfoExample;
import com.me.mysql.mapper.UserInfoMapper;
import com.me.utils.SortUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息
 *
 * @author zhaohaojie
 * @date 2018-12-30 0:33
 */
@Service
@Slf4j
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RedisCacheable(value = RedisKey.UserInfo,key = "'UserInfo_'+#userId")
    public UserInfo getUserInfo(Integer userId){
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserIdEqualTo(userId);
        List<UserInfo> list = userInfoMapper.selectByExample(userInfoExample);
        log.debug("result is "+JSONObject.toJSONString(list));
        return list.stream().findFirst().orElse(new UserInfo());
    }

    @RedisCachePut(value = RedisKey.UserInfo,key = "'UserInfo_'+#userInfo.userId")
    public UserInfo updateUserInfo(UserInfo userInfo){
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUserIdEqualTo(userInfo.getUserId());
        int num = userInfoMapper.updateByExampleSelective(userInfo,example);
        return userInfo;
    }

}

