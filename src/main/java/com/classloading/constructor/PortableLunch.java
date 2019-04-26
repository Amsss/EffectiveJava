package com.classloading.constructor;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-25 10:45
 */
class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
    private Bread xxx = new Bread();
}
