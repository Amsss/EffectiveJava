package com.DesignPattern.Observer.demo;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:16
 */
public interface Observer {

    /**
     * 当主题状态改变时,会将一个String类型字符传入该方法的参数,每个观察者都需要实现该方法
     *
     * @param info
     */
    void update(String info);
}
