package com.me.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhaohaojie
 * @date 2019-04-18 21:09
 */
@Getter
@Setter
@NoArgsConstructor
public class TaskAnnoException extends RuntimeException {

    private String errorMessage;

    private Integer errorCode;

    public TaskAnnoException(String message,Integer errorCode){
        super();
        this.errorCode = errorCode;
        this.errorMessage = message;
    }
}

