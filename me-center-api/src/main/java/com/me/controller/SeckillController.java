package com.me.controller;

import com.me.auth.annotation.SkipAuthentication;
import com.me.entity.SeckillResult;
import com.me.entity.SeckillUrlExposer;
import com.me.mysql.domain.SeckillInventory;
import com.me.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 秒杀控制器类
 * @author zhaohaojie
 * @date 2019-01-24 17:49
 */
@RestController
@RequestMapping(path = "/seckill")
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    /**
     * 暴露秒杀接口，没到秒杀时间获取开始时间和结束时间
     *
     * @author : zhaohaojie
     * @date : 2019/2/7 19:25
     */
    @GetMapping(path= "/getUrl")
    public SeckillUrlExposer getSeckillUrl(String phone ,Integer productId) {
        return seckillService.getSeckillUrlExposer(Long.parseLong(phone),productId);
    }

    /**
     * 执行秒杀
     * @author : zhaohaojie
     * @date : 2019/2/9 21:36
     */
    @PostMapping(path= "/execute")
    @SkipAuthentication
    public SeckillResult seckillExecute(@RequestParam String MD5, @RequestParam Integer productId, @RequestParam String phoneNumber) {
        return seckillService.seckillExecute(MD5, productId, phoneNumber);
    }

    @GetMapping(path= "/seckillInventorys")
    public List<SeckillInventory> getSeckillInventory(){
        return seckillService.getSeckillInventoryList();
    }

}

