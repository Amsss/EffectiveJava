package com.json.fastjson.pojo;

import lombok.Data;

/**
 * @description: 学生
 * @author: zhuzz
 * @date: 2018-10-30 17:15
 */
@Data
public class Student {
    /**
     *
     */
    private String studentName;
    /**
     *
     */
    private Integer studentAge;

    public Student() {
    }

    public Student(String studentName, Integer studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }
}
