package com.jvm.overload;

/**
 * @description: 方法静态分配演示
 * @author: zhuzz
 * @date: 2018-06-19 9:55
 */
public class StaticDispatch {
    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human guy) {
        System.out.println("Hello,guy");
    }

    public void sayHello(Man guy) {
        System.out.println("Hello,gentleman");
    }

    public void sayHello(Woman guy) {
        System.out.println("Hello,lady");
    }

    public static void main(String[] args) {
        //Human 变量的静态类型或者叫外观类型; Man 变量的实际类型
        Human man = new Man();
        Human women = new Woman();
        StaticDispatch sd = new StaticDispatch();

        /**虚拟机（编译器）在重载时是通过参数的静态类型而不是实际类型作为判断依据的。
         * 并且静态类型是编译器可知的，因此，在编译阶段。javac编译器会根据参数的静态类型决定使用
         * 哪个重载版本，所以选择了sayHello(Human guy)作为调用目标，并把这个方法的符号引用写到main()
         * 方法里的两条invokevirtual指令的参数中
         */
        sd.sayHello(man);
        sd.sayHello(women);
    }
}
