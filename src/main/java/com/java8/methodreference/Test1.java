package com.java8.methodreference;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 方法应用Demo
 * 其实是lambda表达式的一个简化写法，所引用的方法其实是lambda表达式的方法体实现，语法也很简单，
 * 左边是容器（可以是类名，实例名），中间是”::”，右边是相应的方法名。如下所示：
 * ObjectReference::methodName
 * @author: zhuzz
 * @date: 2019-02-28 10:09
 */
public class Test1 {
    public static void main(String[] args) {
        IConvert<String, String> convert = Something::startsWith;
        String converted = convert.convert("123");
        Something something = new Something();
        IConvert<String, String> convert2 = something::endWith;
        String converted2 = convert2.convert("Java");
        IConvert<String, Something> convert3 = Something::new;
        Something something3 = convert3.convert("constructors");
        List<String> ss = new ArrayList<>(16);
        ss.add("111 ");
        ss.add("222 ");
        System.out.println(ss);
        ss.forEach(String::length);
        Test1 a = new Test1();
        ss.forEach(a::print);
        System.out.println(ss);
    }

    private String print(String a) {
        System.out.println(a);
        return a;
    }
}
