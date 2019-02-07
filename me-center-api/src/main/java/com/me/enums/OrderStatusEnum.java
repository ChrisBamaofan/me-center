package com.me.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单状态
 *
 * @author zhaohaojie
 * @date 2019-02-07 12:45
 */
@Getter
public enum OrderStatusEnum {

    WaitToPay("秒杀成功待支付",-1),
    Canceled("取消订单",-2),
    Paid("已支付",1),
    Delivered("已配送",2),
    Signed("已签收",3),
    Rejected("拒签",4);



    private String status;
    private Integer id;

    OrderStatusEnum(String status,Integer id){
        this.status = status;
        this.id = id;
    }

    public static String getStringById(){
//        for (OrderStatusEnum status:values()){
//            if ()
//        }
        return null;
    }
}

