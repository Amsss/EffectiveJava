package com.concurrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:55
 */
public class ResourceManage {
    private final Semaphore semaphore;
    private boolean resourceArray[];
    private final ReentrantLock lock;

    public ResourceManage() {
        // 存放厕所状态
        this.resourceArray = new boolean[10];
        // 控制10个共享资源的使用，使用先进先出的公平模式进行共享;公平模式的信号量，先来的先获得信号量
        this.semaphore = new Semaphore(10, true);
        // 公平模式的锁，先来的先选
        this.lock = new ReentrantLock(true);
        for (int i = 0; i < 10; i++) {
            // 初始化为资源可用的情况
            resourceArray[i] = true;
        }
    }

    public void useResource(int userId) {
        try {
            semaphore.acquire();
            // 占到一个坑
            int id = getResourceId();
            System.out.print("userId:" + userId + "正在使用资源，资源id:" + id + "\n");
            // do something，相当于于使用资源
            Thread.sleep(10000);
            // 退出这个坑
            resourceArray[id] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放信号量，计数器加1
            semaphore.release();
        }
    }

    private int getResourceId() {
        int id = -1;
        try {
            lock.lock();
            // 虽然使用了锁控制同步，但由于只是简单的一个数组遍历，效率还是很高的，所以基本不影响性能。
            for (int i = 0; i < 10; i++) {
                if (resourceArray[i]) {
                    resourceArray[i] = false;
                    id = i;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return id;
    }
}
