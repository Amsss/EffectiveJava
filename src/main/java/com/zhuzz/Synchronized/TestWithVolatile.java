package com.zhuzz.Synchronized;

public class TestWithVolatile {
    private static volatile boolean bChanged;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    if (bChanged == true) {
                        System.out.println("!=");
                        System.exit(0);
                    }
                }
            }
        }.start();
        Thread.sleep(1000);
        new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    bChanged = true;
                }
            }
        }.start();
    }

}  
