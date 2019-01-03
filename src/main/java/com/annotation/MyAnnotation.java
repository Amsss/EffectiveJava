package com.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-06-12 16:19
 */
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
}
