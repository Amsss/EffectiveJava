package com.concurrent.semaphore;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:55
 */
public class ResourceUser implements Runnable {
    private ResourceManage resourceManage;
    private int userId;

    public ResourceUser(ResourceManage resourceManage, int userId) {
        this.resourceManage = resourceManage;
        this.userId = userId;
    }

    @Override
    public void run() {
        System.out.print("userId:" + userId + "准备使用资源...\n");
        resourceManage.useResource(userId);
        System.out.print("userId:" + userId + "使用资源完毕...\n");
    }

    public static void main(String[] args) {
        ResourceManage resourceManage = new ResourceManage();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            // 创建多个资源使用者
            Thread thread = new Thread(new ResourceUser(resourceManage, i));
            threads[i] = thread;
        }
        for (int i = 0; i < 100; i++) {
            Thread thread = threads[i];
            try {
                // 启动线程
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}