/**
 * @文件名：Computable.java 
 * @作者:zhuzz
 * @创建时间： 2018-1-17 上午10:24:53
 * @版本:V1.0
 * 版权：版权所有 bsoft 保留所有权力。
 */
package com.concurrent;

/**
 * @author zhuzz
 * @类功能说明:
 * @创建时间:2018-1-17 上午10:24:53
 */

public interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}
