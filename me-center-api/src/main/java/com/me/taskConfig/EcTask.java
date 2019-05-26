package com.me.taskConfig;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhaohaojie
 * @date 2019-04-18 20:59
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EcTask {
    private Object instance;
    private String method;
    private String code;


}

