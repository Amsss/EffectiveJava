package com.dynamicproxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @author: zhuzz
 * @date: 2018-06-20 9:52
 */

public class DynamicProxy implements InvocationHandler {

    Object originalObj;

    Object bind(Object originalObj) {
        this.originalObj = originalObj;
        return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("welcome");
        return method.invoke(originalObj, args);
    }

    public static void main(String[] args) {
        // 通过此语句得到动态生成 的class 文件，然后通过 反编译工具得到代码
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Person person = (Person) new DynamicProxy().bind(new LiuDeHua());
        person.dance("尬");
    }
}
