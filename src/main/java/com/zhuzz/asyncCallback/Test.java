package com.zhuzz.asyncCallback;

/**
 * 
 *@author zhuzz
 * @类功能说明:测试类
 * @创建时间:2017-11-29 上午9:42:42
 */
public class Test {
	public static void main(String[] args) {
		Li li = new Li();
		Wang wang = new Wang(li);
		wang.askQuestion("1 + 1 = ?");
	}
}
