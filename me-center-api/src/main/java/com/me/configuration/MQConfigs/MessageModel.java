package com.me.configuration.MQConfigs;


import cn.hutool.core.date.DateUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaohaojie
 * @date 2019-04-02 18:09
 */
@Getter
@Setter
@Builder
public class MessageModel implements Serializable {

        private String titile;
        private String message;

        @Override
        public String toString() {
            return "MessageModel{" +
                    "titile='" + titile + '\'' +
                    ", message='" + message + '\'' +
                    ", date=" + DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss") +
                    '}';
        }

}

