package com.concurrent.lock.syn;

import java.util.concurrent.locks.StampedLock;

/**
 * @description: synchronized是在JVM层面上实现的，不但可以通过一些监控工具监控synchronized的锁定，
 * 而且在代码执行时出现异常，JVM会自动释放锁定；
 * ReentrantLock、ReentrantReadWriteLock,、StampedLock都是对象层面的锁定，
 * 要保证锁定一定会被释放，就必须将unLock()放到finally{}中；
 * StampedLock 对吞吐量有巨大的改进，特别是在读线程越来越多的场景下；
 * StampedLock有一个复杂的API，对于加锁操作，很容易误用其他方法;
 * 当只有少量竞争者的时候，synchronized是一个很好的通用的锁实现;
 * 当线程增长能够预估，ReentrantLock是一个很好的通用的锁实现;
 * @author: zhuzz
 * @date: 2019-07-07 15:50
 */
public class Point {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    // an exclusively locked method
    // 排它锁-写锁（writeLock）
    void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    //下面看看乐观读锁案例
    // A read-only method
    double distanceFromOrigin() {
        //获得一个乐观读锁
        long stamp = sl.tryOptimisticRead();
        //将两个字段读入本地局部变量
        double currentX = x, currentY = y;
        //检查发出乐观读锁后同时是否有其他写锁发生？
        if (!sl.validate(stamp)) {
            //如果没有，我们再次获得一个读悲观锁
            stamp = sl.readLock();
            try {
                // 将两个字段读入本地局部变量
                currentX = x;
                // 将两个字段读入本地局部变量
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    //下面是悲观读锁案例
    void moveIfAtOrigin(double newX, double newY) {
        // upgrade
        // Could instead start with optimistic, not read mode
        long stamp = sl.readLock();
        try {
            //循环，检查当前状态是否符合
            while (x == 0.0 && y == 0.0) {
                //将读锁转为写锁
                long ws = sl.tryConvertToWriteLock(stamp);
                //这是确认转为写锁是否成功
                if (ws != 0L) {
                    //如果成功 替换票据
                    stamp = ws;
                    //进行状态改变
                    x = newX;
                    //进行状态改变
                    y = newY;
                    break;
                } else {
                    //如果不能成功转换为写锁 我们显式释放读锁
                    sl.unlockRead(stamp);
                    //显式直接进行写锁 然后再通过循环再试
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }
}
