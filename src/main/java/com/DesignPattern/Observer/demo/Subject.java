package com.DesignPattern.Observer.demo;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:18
 */
public interface Subject {
    /**
     * 添加观察者
     *
     * @param obj
     */
    void addObserver(Observer obj);

    /**
     * 移除观察者
     *
     * @param obj
     */
    void deleteObserver(Observer obj);

    /**
     * 当主题方法改变时,这个方法被调用,通知所有的观察者
     *
     */
    void notifyObserver();
}
