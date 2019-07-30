package com.framework.control;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-24 18:02
 */
public abstract class AbstractEvent {
    /**
     * 事件时间
     */
    private long eventTime;

    public AbstractEvent(long eventTime) {
        this.eventTime = eventTime;
    }

    public boolean ready() {
        return System.currentTimeMillis() >= eventTime;
    }

    /**
     * 触发事件
     */
    abstract public void action();

    /**
     * 时间描述
     *
     * @return
     */
    abstract public String description();
}
