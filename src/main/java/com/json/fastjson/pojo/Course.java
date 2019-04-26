package com.json.fastjson.pojo;

import lombok.Data;

/**
 * @description: 课程pojo
 * @author: zhuzz
 * @date: 2018-10-30 17:14
 */
@Data
public class Course {
    /**
     *
     */
    private Integer code;
    /**
     *
     */
    private String courseName;

    public Course() {
    }

    public Course(String courseName, Integer code) {
        this.courseName = courseName;
        this.code = code;
    }
}
