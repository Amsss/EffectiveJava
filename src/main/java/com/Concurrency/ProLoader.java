/**
 * @文件名：ProLoader.java 
 * @作者:zhuzz
 * @创建时间： 2018-1-16 下午6:52:47
 * @版本:V1.0
 * 版权：版权所有 bsoft 保留所有权力。
 */
package com.Concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zhuzz
 * @类功能说明:
 * @创建时间:2018-1-16 下午6:52:47
 */

public class ProLoader {
	private final FutureTask future = new FutureTask(new Callable<String>() {

		public String call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
	});
}
