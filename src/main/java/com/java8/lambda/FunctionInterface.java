package com.java8.lambda;

/**
 * @description: 定义一个函数式接口需要注意：
 * 1.添加@FunctionalInterface注解.
 * 2.有且只有一个抽象方法.可以有多个default方法和static方法,但是这些方法都必须实现.
 * 对于@FunctionalInterface注解,其实不加也可以,完全是可以通过编译的,但前提是这个接口需要满足上面的第二个注意点.
 * @author: zhuzz
 * @date: 2019-02-28 9:26
 */
@FunctionalInterface
public interface FunctionInterface {
    void test();
}
