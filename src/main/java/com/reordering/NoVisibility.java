package com.reordering;

/**d
 * @description: "重排序"现象
 * @author: zhuzz
 * @date: 2018-07-10 14:04
 */
public class NoVisibility {
    private static boolean ready = false;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        ready = true;
        number = 42;
    }
}
