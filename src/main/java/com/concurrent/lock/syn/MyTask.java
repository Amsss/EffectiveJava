package com.concurrent.lock.syn;

import java.util.TimerTask;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:45
 */
class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("您该起床了!!!!");
    }
}

