package com.concurrent.callable;

import java.util.concurrent.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/7/27 19:35
 */
public class Memoizer<V, A> implements Computable<A, V> {

    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = new Callable<V>() {
                    @Override
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
     * @param t
     * @return
     * @方法说明：如果Throwable 是 Error ，那么将他抛出；
     * 如果是RuntimeException 那么返回， 否则抛出IllegalStateException
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
