package com.Annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018/12/24 19:39
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Description {
    /**
     *
     * @return
     */
    String value();
} 