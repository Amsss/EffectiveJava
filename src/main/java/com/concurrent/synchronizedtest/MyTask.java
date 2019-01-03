package com.concurrent.synchronizedtest;

import java.util.TimerTask;

class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("您该起床了!!!!");
    }
}

