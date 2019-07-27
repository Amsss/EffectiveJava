package com.concurrent.lock.syn;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * @description: 
 * @author: zhuzz
 * @date: 2019/1/7 10:50
 */
public class TimerDemo {
    public static void main(String[] args) {
        //创建定时器对象
        Timer timer = new Timer();
        //在3秒后执行MyTask类中的run方法
        timer.schedule(new MyTask(), 3000);
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        timer.cancel();
    }
}
