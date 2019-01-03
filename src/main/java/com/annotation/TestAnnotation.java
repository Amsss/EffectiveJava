package com.annotation;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 具体关于Annotation的API的用法请参见javaDoc文档
 * @author: zhuzz
 * @date: 2018/12/24 19:34
 */
public class TestAnnotation {

    public static void main(String[] args) throws Exception {
        //加载类
        String className = "com.annotation.OpenSource";
        Class classs = Class.forName(className);
        //判断是否带@Description注解
        boolean flag = classs.isAnnotationPresent(Description.class);
        if (flag) {
            Description des = (Description) classs.getAnnotation(Description.class);
            System.out.println("描述:" + des.value());
            System.out.println("-----------------");
        }
        //把JavaEyer这一类有利用到@Name的全部方法保存到Set中去
        Method[] method = classs.getMethods();
        Set<Method> set = new HashSet<>(16);
        for (Method aMethod : method) {
            boolean otherFlag = aMethod.isAnnotationPresent(Name.class);
            if (otherFlag) {
                set.add(aMethod);
            }
        }
        for (Method m : set) {
            Name name = m.getAnnotation(Name.class);
            System.out.println(name.originate());
            System.out.println("创建的社区:" + name.community());
        }
    }
} 
