package com.Annotation;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class TestAnnotation {

    /**
     * @Author: Zezhao.Zhu
     * @Description:  具体关天Annotation的API的用法请参见javaDoc文档
     * @Date: 11:04 2018/5/9
     */
    public static void main(String[] args) throws Exception {
        //加载类
        String CLASS_NAME = "com.Annotation.OpenSource";
        Class test = Class.forName(CLASS_NAME);
        //判断是否带@Description注解
        boolean flag = test.isAnnotationPresent(Description.class);
        if (flag) {
            Description des = (Description) test.getAnnotation(Description.class);
            System.out.println("描述:" + des.value());
            System.out.println("-----------------");
        }

        //把JavaEyer这一类有利用到@Name的全部方法保存到Set中去
        Method[] method = test.getMethods();
        Set<Method> set = new HashSet<Method>();
        for (int i = 0; i < method.length; i++) {
            boolean otherFlag = method[i].isAnnotationPresent(Name.class);
            if (otherFlag) set.add(method[i]);
        }
        for (Method m : set) {
            Name name = m.getAnnotation(Name.class);
            System.out.println(name.originate());
            System.out.println("创建的社区:" + name.community());
        }
    }
} 
