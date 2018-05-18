package com.zhuzz.classload.demo;

public class ClassLoadContext {

    private final Class<?> m_caller;

    public final Class<?> getCallerClass() {
        return m_caller;
    }

    ClassLoadContext(final Class<?> caller) {
        m_caller = caller;
    }

}
