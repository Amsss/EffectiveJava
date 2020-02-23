package com.closeable;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-08-28 9:18
 */
public class AutoCloseableTest {

    public static void main(String[] args) {
        try (ConnectionLock lock = new ConnectionInnerLock()) {
            lock.unlock();
            //do something lock
            System.out.println("doing business...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
