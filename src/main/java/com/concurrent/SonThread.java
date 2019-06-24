package com.concurrent;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-11 14:54
 */
public class SonThread extends Thread {

    @Override
    public void run() {
        System.out.println("wo yao kai shi le 兄嘚");
    }

    public static void main(String[] args) {
        SonThread sonThread = new SonThread();
        sonThread.test();
    }

    public void test() {
        start();
    }
}
