package com.reconfiguration;

import java.util.ArrayList;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-10-10 18:03
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(10);
        list.add("001");
        list.add("002");
        Student s = new Student("Tom", list);

        ArrayList<String> anotherList = s.getCourses();

        anotherList.add("999");

        System.out.println("Tom's  course.length  =  " + s.getCourses().size());
    }
}
