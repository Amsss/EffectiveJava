/**
 * @文件名：ClassLoaderTest.java
 * @作者:zhuzz
 * @创建时间： 2018-1-29 上午10:09:30
 * @版本:V1.0
 * @版权： 版权所有 zhuzz 保留所有权力。
 */
package com.ClassLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhuzz
 * @类功能说明: 自定义类加载器测试(不同类加载器对instanceof关键字运算结果的影响)
 * 一个是系统应用类加载器加载的 另一个是自定义加载器加载
 * @创建时间:2018-1-29 上午10:09:30
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
	    //定义类加载器
		ClassLoader myClassLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name)
					throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1)
							+ ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					//is = this.getClass().getResourceAsStream("/" + fileName);
					//is = this.getClass().getClassLoader().getResourceAsStream(fileName); //拿到资源
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					e.printStackTrace();
				}
				//loadClass(String, boolean)函数即实现了双亲委派模型
				return loadClass(name, false);
			}
		};


        //实现类加载
		try {
			Object obj = myClassLoader.loadClass("com.ClassLoader.ClassLoaderTest").newInstance();
			System.out.println(obj.getClass());
			System.out.println(obj instanceof com.ClassLoader.ClassLoaderTest);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
