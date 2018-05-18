/**
 * @文件名：ClassLoaderTest.java 
 * @作者:zhuzz
 * @创建时间： 2018-1-29 上午10:09:30
 * @版本:V1.0
 * 版权：版权所有 bsoft 保留所有权力。
 */
package com.ClassLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhuzz
 * @类功能说明: 自定义类加载器测试
 * @创建时间:2018-1-29 上午10:09:30
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
		ClassLoader myClassLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name)
					throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1)
							+ ".classTest";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					e.printStackTrace();
				}
				//123
				//loadClass(String, boolean)函数即实现了双亲委派模型
				return loadClass(name, false);
			}
		};
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
	/**
	 * 测试list为final的情况下对for each 循环的影响
	 * */
	/*public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		for (final String b :list) {
			System.out.println(b);
		}
	}*/
}
