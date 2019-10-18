package com.annotation;

import java.lang.annotation.*;

/**
 * @description: 自定义Description注解类
 * @author: zhuzz
 * @date: 2018/12/24 19:39
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Description {
    /**
     * @return
     */
    String value();
} 