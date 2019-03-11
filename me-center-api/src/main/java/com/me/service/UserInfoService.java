package com.me.service;

import com.alibaba.fastjson.JSONObject;
import com.me.cache.RedisCacheKey;
import com.me.cache.annotation.RedisCachePut;
import com.me.cache.annotation.RedisCacheable;
import com.me.mysql.domain.UserInfo;
import com.me.mysql.domain.UserInfoExample;
import com.me.mysql.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @RedisCacheable(value = RedisCacheKey.UserInfo,key = "'UserInfo_'+#userId")
    public UserInfo getUserInfo(Integer userId){
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserIdEqualTo(userId);
        List<UserInfo> list = userInfoMapper.selectByExample(userInfoExample);
        return list.stream().findFirst().orElse(new UserInfo());
    }

    @RedisCachePut(value = RedisCacheKey.UserInfo,key = "'UserInfo_'+#userInfo.userId")
    public UserInfo updateUserInfo(UserInfo userInfo){
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUserIdEqualTo(userInfo.getUserId());
        int num = userInfoMapper.updateByExampleSelective(userInfo,example);
        return userInfo;
    }

}

