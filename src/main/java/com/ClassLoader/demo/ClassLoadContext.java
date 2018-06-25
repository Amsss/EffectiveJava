package com.ClassLoader.demo;

public class ClassLoadContext {

    private final Class<?> m_caller;

    //返回类给ClassLoaderResolver或ResourceLoader使用
    public final Class<?> getCallerClass() {
        return m_caller;
    }

    ClassLoadContext(final Class<?> caller) {
        m_caller = caller;
    }

}
