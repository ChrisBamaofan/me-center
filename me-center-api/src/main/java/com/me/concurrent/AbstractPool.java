package com.me.concurrent;

/**
 * 抽象线程池
 *
 * @author zhaohaojie
 * @date 2019-02-13 12:17
 */
public interface AbstractPool {

    void addNewTaskToQueue(TaskData taskData);

    Integer getQueueSize();

}
