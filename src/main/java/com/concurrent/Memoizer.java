/**
 * @文件名：Memoizer.java 
 * @作者:zhuzz
 * @创建时间： 2018-1-17 上午10:23:34
 * @版本:V1.0
 * 版权：版权所有 bsoft 保留所有权力。
 */
package com.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author zhuzz
 * @param <V>
 * @param <A>
 * @类功能说明:
 * @创建时间:2018-1-17 上午10:23:34
 */

public class Memoizer<V, A> implements Computable<A, V> {

	private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
	private final Computable<A, V> c;

	public Memoizer(Computable<A, V> c) {
		this.c = c;

	}

	public V compute(final A arg) throws InterruptedException {
		while (true) {
			Future<V> f = cache.get(arg);
			if (f == null) {
				Callable<V> eval = new Callable<V>() {
					public V call() throws Exception {
						return c.compute(arg);
					}
				};
				FutureTask<V> ft = new FutureTask<V>(eval);
				f = cache.putIfAbsent(arg, ft);
				if (f == null) {
					f = ft;
					ft.run();
				}
				try {
					return f.get();
				} catch (CancellationException e) {
					cache.remove(arg, f);
				} catch (ExecutionException e) {
					throw launderThrowable(e);
				}
			}
		}
	}
	/**
	 * @方法说明：如果Throwable 是 Error ，那么将他抛出；
	 * 如果是RuntimeException 那么返回， 否则抛出IllegalStateException
	 * @param t
	 * @return
	 */
	public static RuntimeException launderThrowable(Throwable t) {
		if (t instanceof RuntimeException) {
			return (RuntimeException) t;
		} else if (t instanceof Error) {
			throw (Error) t;
		} else {
			throw new IllegalStateException("Not unchecked", t);
		}
	}
}
