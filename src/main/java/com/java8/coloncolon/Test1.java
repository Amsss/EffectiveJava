package com.java8.coloncolon;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-02-28 10:09
 */
public class Test1 {
    public static void main(String[] args) {
        // static methods
        IConvert<String, String> convert = Something::startsWith;
        String converted = convert.convert("123");

        // object methods
        Something something = new Something();
        IConvert<String, String> convert2 = something::endWith;
        String converted2 = convert2.convert("Java");

        IConvert<String, Something> convert3 = Something::new;
        Something something3 = convert3.convert("constructors");

        List<String> ss = new ArrayList<>(16);
        ss.add("111 ");
        ss.add("222 ");
        System.out.println(ss);
        ss.forEach((s)->s.substring(2));
        ss.forEach(String::length);
        Test1 a = new Test1();
        ss.forEach(a::print);
        System.out.println(ss);
    }

    private String print(String a){
        System.out.println(a);
        return a;
    }
}
