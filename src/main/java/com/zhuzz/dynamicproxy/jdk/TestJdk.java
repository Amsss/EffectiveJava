package com.zhuzz.dynamicproxy.jdk;

public class TestJdk {
	
	public static void main(String[] args) {
		LiuDeHuaProxy proxy = new LiuDeHuaProxy();
		Person p = proxy.getProxy();
		String retValue = p.sing("冰雨");
		System.out.println(retValue);
		String value = p.dance("江南style");
		System.out.println(value);
	}
}
