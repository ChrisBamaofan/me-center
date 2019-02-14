package com.me.concurrent;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhaohaojie
 * @date 2019-02-13 12:21
 */
@ConfigurationProperties(prefix = "myPool")
@Component
@Data
public class PoolParam {

    private Integer corePoolSize;

    private Integer keepAliveSeconds;

    private Integer maxPoolSize;

    private Integer queueCapacity;
}

