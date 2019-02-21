package com.me.concurrent;

import lombok.Data;

/**
 * 一部任务类，需要与任务表一致 task,task_success,task_error
 * @author zhaohaojie
 * @date 2019-02-14 15:07
 */
@Data
public class TaskData {
    private Long taskId;
    private String taskCode;//业务编号
    private String taskMessage;//task中转信息
    private String taskResult;//执行目前的结果，如果成功就删除这条task任务，放入success表
    private Integer taskErrorNumber;//失败次数
    private Long lockId;//上锁的lockId
}

