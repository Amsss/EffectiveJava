package com.reconfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 重构后的Student
 * @author: zhuzz
 * @date: 2018-10-10 18:05
 */
public class Student1 {
    private String name;
    private ArrayList<String> courses;

    public Student1(String name, ArrayList<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public String removeCourse(String course) {
        boolean removed = courses.remove(courses);
        if (removed) {
            return course;
        } else {
            return null;
        }
    }

    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }
}
