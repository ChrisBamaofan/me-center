package com.me.service.sms;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ailieping短信上下文
 *
 * 区分不同类型的短信
 * @author zhaohaojie
 * @date 2019-05-26 23:21
 */
@Data
public class AlpSmsContext {

    /**
     * 面试 和 offer 共用 上下文
     * @author : zhaohaojie
     * @date : 2019/5/27 0:10
     */
    private String candidateName;
    private String enterpriseName;
    private String interviewPrincipal;
    private String interviewPrincipalPhone;

    /**
     * 面试模块上下文
     *
     * @author : zhaohaojie
     * @date : 2019/5/26 23:23
     */
    private Integer interviewId;
    private LocalDateTime interviewTime;
    private String interviewAddress;
    private String interviewType;
    private String interviewMode;

    /**
     * offer相关上下文
     * @author : zhaohaojie
     * @date : 2019/5/26 23:29
     */
    // 入职日期
    private LocalDateTime onnBoardDate;
    // 试用期
    private String probation;
    // 入职地点 TODO 可能和面试地点一样
    private String onnBoardAddress;
    // 确认接收offer按钮的url内容
    private String acceptOfferUrl;
    // 拒绝offer按钮的url内容
    private String refuseOfferUrl;
    // 填写面试登记表的按钮
    private String registrationFormUrl;
    // 附件信息
    private List<Object> annexList;
}

