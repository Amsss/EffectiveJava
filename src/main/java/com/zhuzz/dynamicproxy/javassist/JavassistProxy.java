package com.zhuzz.dynamicproxy.javassist;


import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;

public class JavassistProxy implements MethodHandler {
    ProxyFactory proxyFactory = new ProxyFactory();


    public Object getProxy(Class clazz) throws IllegalAccessException, InstantiationException {
        // 设置需要创建子类的类
        proxyFactory.setSuperclass(clazz);
        proxyFactory.setHandler(this);
        // 通过字节码技术动态创建子类实例
        return proxyFactory.createClass().newInstance();
    }

    // 实现MethodHandler接口方法
    @Override
    public Object invoke(Object o, Method method, Method proceed, Object[] objects) throws Throwable {
        System.out.println("前置代理");
        // 通过代理类调用父类中的方法
        Object result = proceed.invoke(o, objects);
        System.out.println("后置代理");
        return result;
    }
}
