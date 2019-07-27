package com.java8.defaultmethod;

/**
 * @description: 若实现的2个接口都有同样的默认方法，需要实现接口，同时可以通过类名.super指定要调用的方法
 * @author: zhuzz
 * @date: 2019-03-01 9:52
 */
public class F implements E, D{
    @Override
    public void hello() {
        D.super.hello();
    }

    public static void main(String[] args) {
        F f = new F();
        f.hello();
    }
}
