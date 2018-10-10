package com.reconfiguration;

import java.util.ArrayList;

/**
 * @description: 重构前的Student
 * @author: zhuzz
 * @date: 2018-10-10 18:00
 */
public class Student {

    private String name;
    private ArrayList<String> courses;

    public Student(String name, ArrayList<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
