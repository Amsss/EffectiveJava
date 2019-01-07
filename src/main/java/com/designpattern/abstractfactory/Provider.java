package com.designpattern.abstractfactory;

/**
 * @description: 生产者
 * @author: zhuzz
 * @date: 2019/1/7 11:00
 */
public interface Provider {

    /**
     * 生产者
     *
     * @return
     */
    Sender produce();
}
