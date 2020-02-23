package com.json.fastjson.pojo;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @description: 教师
 * @author: zhuzz
 * @date: 2018-10-30 17:15
 */
@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@RequiredArgsConstructor
public class Teacher {
    /**
     *
     */
    @NonNull
    private String teacherName;
    /**
     *
     */
    @NonNull
    private Integer teacherAge;
    /**
     *
     */
    @NonNull
    private Course course;
    /**
     *
     */
    @NonNull
    private List<Student> students;

   /* public Teacher() {
    }*/

   /* public Teacher(String teacherName, Integer teacherAge, Course course, List<Student> students) {
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
        this.course = course;
        this.students = students;
    }*/
}
