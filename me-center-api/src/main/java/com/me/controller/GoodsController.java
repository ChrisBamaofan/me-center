package com.me.controller;

import com.me.mysql.domain.GoodsInfo;
import com.me.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohaojie
 * @date 2019-01-02 16:24
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/getGoodsInfoByGoodsId/{id}")
    public GoodsInfo getGoodsInfoByGoodsId(@PathVariable("id") Integer id){
        return goodsService.getGoodsInfoByGoodsId(id);
    }
}

