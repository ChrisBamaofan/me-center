package com.me.service;

import com.me.entity.SeckillResult;
import com.me.exception.SeckillException;
import com.me.mysql.domain.SeckillSuccess;
import com.me.mysql.domain.UserInfo;
import com.me.mysql.domain.UserInfoExample;
import com.me.mysql.mapper.SeckillSuccessMapper;
import com.me.mysql.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    public UserInfo getUserInfo(Integer id){
        log.debug("start."+Thread.currentThread().getName());
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserIdEqualTo(id);
        List<UserInfo> list = userInfoMapper.selectByExample(userInfoExample);
        log.debug("end."+Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list.stream().findFirst().orElse(new UserInfo());

    }

}

