package com.java8.defaultmethod;

/**
 * @description:
 * 如果一个类使用相同的函数签名从多个地方（比如另一个类或接口）继承了方法，通过三条规则可以进行判断:
 * 1.类中的方法优先级最高，类或父类中声明的方法的优先级高于任何声明为默认方法的优先级。
 * 2.如果无法依据第一条进行判断,那么子接口的优先级更高:函数签名相同时,优先选择拥有最具体实现的默认方法的接口,即如果B继承了A,那么B就比A更加具体。
 * 3.最后,如果还是无法判断,继承了多个接口的类必须通过显示覆盖和调用期望的方法,显示地选择使用哪一个默认方法的实现。
 * @author: zhuzz
 * @date: 2019-03-01 9:47
 */
public class C implements A, B{
    @Override
    public void doSomething() {
        System.out.println("c object need do something");
    }

    public static void main(String[] args) {
        A obj = new C();
        obj.hello();    //调用B的默认方法
        obj.foo();    //调用A的默认方法
        obj.doSomething();
    }
}
