package com.me.service;

import com.me.mysql.domain.GoodsInfo;
import com.me.mysql.mapper.GoodsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaohaojie
 * @date 2019-01-02 16:24
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    public GoodsInfo getGoodsInfoByGoodsId(Integer id){

        return goodsInfoMapper.selectByPrimaryKey(id);
    }
}

