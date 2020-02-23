package com.spi;

import java.util.ServiceLoader;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-03-08 15:38
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<DubboService> spiLoader = ServiceLoader.load(DubboService.class);
        for (DubboService dubboService : spiLoader) {
            dubboService.sayHello();
        }
    }
}
