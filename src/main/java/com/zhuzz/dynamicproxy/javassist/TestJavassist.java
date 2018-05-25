package com.zhuzz.dynamicproxy.javassist;

public class TestJavassist {
	public static void main(String[] args) {
		JavassistProxy proxy = new JavassistProxy();
		// 通过生成子类的方式创建代理类
		SayHello proxyImp = null;
		try {
			proxyImp = (SayHello) proxy.getProxy(SayHello.class);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		proxyImp.say();
	}
}
