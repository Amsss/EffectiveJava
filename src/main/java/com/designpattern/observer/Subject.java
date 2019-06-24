package com.designpattern.observer;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:51
 */
public interface Subject {

    /**
     * 增加观察者
     *
     * @param observer
     */
    void add(Observer observer);

    /**
     * 删除观察者
     *
     * @param observer
     */
    void del(Observer observer);

    /**
     * 通知所有的观察者
     */
    void notifyObservers();

    /**
     * 自身的操作
     */
    void operation();
}
