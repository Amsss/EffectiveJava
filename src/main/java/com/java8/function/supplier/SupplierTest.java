package com.java8.function.supplier;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @description: 创建对象的
 * @author: zhuzz
 * @date: 2019-02-28 10:50
 */
public class SupplierTest {

    private int age;

    SupplierTest() {
        System.out.println(age);
    }

    SupplierTest(int a) {
        this.age = a;
        System.out.println(age);
    }

    public static void main(String[] args) {
        //创建Supplier容器，声明为TestSupplier类型，此时并不会调用对象的构造方法，即不会创建对象
        Supplier<SupplierTest> sup = SupplierTest::new;
        Function<Integer, SupplierTest> function = integer -> new SupplierTest(integer);
        System.out.println("----------------------");
        //调用get()方法，此时会调用对象的构造方法，即获得到真正对象
        SupplierTest supplierTest = sup.get();
        System.out.println(supplierTest);
        System.out.println(function.apply(20));
        //每次get都会调用构造方法，即获取的对象不同
        SupplierTest supplierTest1 = sup.get();
        System.out.println(supplierTest1);
        System.out.println(function.apply(30));
    }
}
