package com.reconfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-10-10 18:06
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("001");
        list.add("002");
        Student1 s = new Student1("Tom", list);
        List<String> anotherList = s.getCourses();
        /**
         *    throws    java.lang.UnsupportedOperationException
         *    should    replace    with    s.addCourse(String    course)
         */
        List<String> copy = new ArrayList<>(anotherList);
        copy.add("999");
        //    never    reached
        System.out.println("Tom's course.length = " + s.getCourses().size());
    }
}
