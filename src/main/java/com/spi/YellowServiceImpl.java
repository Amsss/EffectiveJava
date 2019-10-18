package com.spi;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-03-08 15:38
 */
public class YellowServiceImpl implements DubboService {
    @Override
    public void sayHello() {
        System.out.println("我是YellowService服务实现");
    }
}
