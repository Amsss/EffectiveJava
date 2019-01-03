package com.annotation;

import java.lang.annotation.*;

/**
 * @description: 注意这里的@Target与@Description里的不同,参数成员也不同
 * @author: zhuzz
 * @date: 2018/12/24 19:39
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {
    /**
     *
     * @return
     */
    String originate();

    /**
     *
     * @return
     */
    String community();
} 