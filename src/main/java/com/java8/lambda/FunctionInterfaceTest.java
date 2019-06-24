package com.java8.lambda;

import java.util.logging.Filter;

/**
 * @description: Lambda表达式
 * 能够接收Lambda表达式的参数类型，是一个只包含一个方法的接口。
 * 只包含一个方法的接口称之为“函数接口”。
 * Lambda表达式基本的语法规则：
 * 无参数，无返回值；
 * 有参数，无返回值；
 * 有参数，有返回值。
 * @author: zhuzz
 * @date: 2019-02-28 9:26
 */
public class FunctionInterfaceTest {
    public static void testLambda() {
        func(new FunctionInterface() {
            @Override
            public void test() {
                System.out.println("Hello World!");
            }
        });
        //使用Lambda表达式代替上面的匿名内部类
        func(() -> System.out.println("Hello World"));
        //关注Lambda表达式“(x) -> Sysout.out.println("Hello World" + x)”，左边传递的是参数，
        // 此处并没有指明参数类型，因为它可以通过上下文进行类型推导，
        // 但在有些情况下不能推导出参数类型（在编译时不能推导通常IDE会提示），此时则需要指明参数类型。
        func1((x) -> System.out.println("Hello World" + x));

        func2((x) -> System.out.println("Hello World" + x));

        func3((x) -> false);

        func3((x) -> {
            System.out.println("Hello World" + x);
            return true;
        });
    }

    private static void func(FunctionInterface functionInterface) {
        functionInterface.test();
    }

    private static void func1(FunctionInterface1 functionInterface1) {
        int a = 1;
        functionInterface1.test(a);
    }

    private static void func2(FunctionInterface2 functionInterface2) {
        int a = 2;
        functionInterface2.test(a);
    }

    private static void func3(FunctionInterface3 functionInterface3) {
        int a = 1;
        boolean b = functionInterface3.test(a);
        System.out.println(b);
    }

    private static void func4(FunctionInterface4 functionInterface4) {
        int a = 2;
        functionInterface4.test(a);
    }

    public static void main(String[] args) {
        testLambda();
    }
}
