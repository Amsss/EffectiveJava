package com.zhuzz.classload.demo;

public interface IClassLoadStrategy {

	ClassLoader getClassLoader(ClassLoadContext ctx);

}
