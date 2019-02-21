package com.me.controller;

import com.me.mysql.domain.BaseControl;
import com.me.mysql.domain.BaseControlExample;
import com.me.mysql.mapper.BaseControlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 操作控件控制器
 *
 * @author zhaohaojie
 * @date 2019-01-28 17:24
 */
@RestController
public class BaseControlController {

    @Autowired
    private BaseControlMapper baseControlMapper;

    @PostMapping("/baseControl/update")
    public void updateBaseControl(@RequestBody BaseControl baseControl){
    }

    @GetMapping("/baseControl/get")
    public void getBaseControlMapper(BaseControl baseControl){
        BaseControlExample example = new BaseControlExample();
        baseControlMapper.selectByExample(example);
    }
}

