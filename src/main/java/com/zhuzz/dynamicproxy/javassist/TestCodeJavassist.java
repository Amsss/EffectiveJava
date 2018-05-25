package com.zhuzz.dynamicproxy.javassist;

public class TestCodeJavassist {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		JavassistProxyFactory<SayHello> proxy = new JavassistProxyFactory<SayHello>();
		SayHello sayHello = new SayHello();
		proxy.setTarget(sayHello);
		SayHello sayHelloProxy = proxy.getProxy();
		sayHelloProxy.say();
	}
}
