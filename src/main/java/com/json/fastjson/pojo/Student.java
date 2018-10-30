package com.json.fastjson.pojo;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-10-30 17:15
 */
public class Student {
    private String studentName;
    private Integer studentAge;

    public Student() {
    }

    public Student(String studentName, Integer studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                '}';
    }
}
