package com.me.configuration;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * mybatis配置类
 *
 * @author zhaohaojie
 * @date 2019-01-02 11:17
 */
@Configuration
public class MybatisConfiguration {

//    @MapperScan(basePackages = "com.me.mysql.mapper",sqlSessionFactoryRef = "mybatisSqlSessionFactory")
//    public static class mybatis2Configuration(){}

    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}

