package com.controlframework;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-24 18:02
 */
public abstract class AbstractEvent {
    private long evtTime;

    public AbstractEvent(long eventTime) {
        evtTime = eventTime;
    }

    public boolean ready() {
        return System.currentTimeMillis() >= evtTime;
    }

    abstract public void action();

    abstract public String description();
}
