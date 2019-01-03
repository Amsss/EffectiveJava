package com.classLoader.demo;

/**
 * @description: 
 * @author: zhuzz
 * @date: 2019/1/3 16:01
 */
public interface IClassLoadStrategy {

    ClassLoader getClassLoader(ClassLoadContext ctx);

}
