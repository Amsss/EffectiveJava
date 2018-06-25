package com.ClassLoader.demo;

public interface IClassLoadStrategy {

    ClassLoader getClassLoader(ClassLoadContext ctx);

}
