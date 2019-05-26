package com.me.controller;

import com.me.auth.annotation.SkipAuthentication;
import com.me.mysql.domain.GoodsInfo;
import com.me.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohaojie
 * @date 2019-01-02 16:24
 */
@RestController
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/getGoodsInfoByGoodsId/{id}")
    @SkipAuthentication
    public GoodsInfo getGoodsInfoByGoodsId(@PathVariable("id") Integer id){
        log.debug("test for debugging.");
        return goodsService.getGoodsInfoByGoodsId(id);
    }
}

