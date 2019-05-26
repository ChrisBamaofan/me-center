package com.me.service;

import com.me.entity.SeckillResult;
import com.me.exception.SeckillException;
import com.me.mysql.domain.SeckillSuccess;
import com.me.mysql.mapper.SeckillSuccessMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author zhaohaojie
 * @date 2019-02-10 16:43
 */
@Service
@Slf4j
public class SeckillSuccessService {

    @Autowired
    private SeckillSuccessMapper seckillSuccessMapper;



    @Transactional(propagation = Propagation.NESTED)
    public SeckillResult insertSuccess(SeckillSuccess seckillSuccess){
        try{
            int successNumber = seckillSuccessMapper.insert(seckillSuccess);
            //重复秒杀
            if (successNumber == 0){
                throw new SeckillException("秒杀失败",-1);
            }else if (successNumber == 1){
                return new SeckillResult("秒杀成功",1);
            }
        }catch (RuntimeException exp){
            log.debug("重复秒杀，phone={},id={}",seckillSuccess.getPhoneNumber(),seckillSuccess.getProductId());
            throw new SeckillException("重复秒杀",-1);
        }
        throw new SeckillException("秒杀失败",-1);
    }
}

