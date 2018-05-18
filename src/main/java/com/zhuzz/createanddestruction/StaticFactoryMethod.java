package com.zhuzz.createanddestruction;

import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.zhuzz.serviceproviderframework.ProviderImpl;
import com.zhuzz.serviceproviderframework.Services;

/**
 * 
 *@author zhuzz
 * @类功能说明:
 * @创建时间:2017-10-25 下午4:19:09
 */
public class StaticFactoryMethod {
	
	/**
	 * 基本类型转换成Boolean对象引用
	 * @方法说明：
	 * @param a
	 * @return
	 */
	public static Boolean valueOf(boolean a) {
		return a ? Boolean.TRUE : Boolean.FALSE;
	}
	
	
	public static void main(String[] args) {
		
		//静态工厂方法--------------经常创建相同的对象 例子
		//BigInteger i = BigInteger.probablePrime(3, new Random(100));
		//System.out.println(i);
		//Boolean.valueOf(true);
		//List<String> a = new ArrayList<String>();
		//EnumSet a = EnumSet;
		
	}
}
