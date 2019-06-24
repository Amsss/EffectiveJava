package com.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @description: 方法分派规则(大失败 : 网上解释https : / / www.zhihu.com / question / 40427344)
 * @author: zhuzzd
 * @date: 2018-06-19 17:08
 */
public class Test {
    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("i am father");
        }
    }

    /**
     * 实现grandfather的调用
     */
    class Son extends Father {
        @Override
        void thinking() {
            System.out.println("i am son");
            try {
                //可以使用"super"关键字很方便地调用到父类的方法，但如果要方法祖类的方法呢
                //super.thinking();
                //MethodHandles.Lookup lookup = MethodHandles.lookup();
                //1.7之后的解决办法
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", MethodType.methodType(void.class), getClass());
                mh.invoke(this);
            } catch (Throwable e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        (new Test().new Son()).thinking();
    }
}
