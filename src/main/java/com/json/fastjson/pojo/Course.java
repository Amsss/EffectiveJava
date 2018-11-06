package com.json.fastjson.pojo;

/**
 * @description: 课程pojo
 * @author: zhuzz
 * @date: 2018-10-30 17:14
 */
public class Course {
    private Integer code;
    private String courseName;

    public Course() {
    }

    public Course(String courseName, Integer code) {
        this.courseName = courseName;
        this.code = code;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", code=" + code +
                '}';
    }
}
