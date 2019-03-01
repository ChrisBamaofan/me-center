package com.me.redis.exception;

/**
 * redis异常类
 *
 * @author zhaohaojie
 * @date 2019-03-01 17:32
 */
public class RedisException extends RuntimeException{
    private String errorMsg;
    private Integer errorCode;

    public RedisException(String errorMsg, Integer errorCode) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public RedisException(String message, Throwable cause, String errorMsg, Integer errorCode) {
        super(message, cause);
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }
}

