package com.json.fastjson.pojo;

import lombok.Data;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-10-30 17:16
 */
@Data
public class Tutor {
    /**
     *
     */
    private Integer tutorId;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String email;

    public Tutor() {
    }

    public Tutor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Tutor(Integer tutorId, String name, String email) {
        this.tutorId = tutorId;
        this.name = name;
        this.email = email;
    }
}
