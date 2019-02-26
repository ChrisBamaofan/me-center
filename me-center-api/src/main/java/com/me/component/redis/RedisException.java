package com.me.component.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 调用redis异常
 * @author zhaohaojie
 * @date 2019-02-25 15:17
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RedisException extends RuntimeException{

    private String message;
    private Integer code;
}

