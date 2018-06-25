package com.jvm.override;

/**
 * @Description: 方法动态分配演示
 * @author: zhuzz
 * @date: 2018-06-19 9:55
 */
public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {

        @Override
        protected void sayHello() {
            System.out.println("man say Hello");
        }
    }

    static class Woman extends Human {

        @Override
        protected void sayHello() {
            System.out.println("woman say Hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human women = new Woman();
        //invokevirtual指令的多态查找
        man.sayHello();
        women.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
