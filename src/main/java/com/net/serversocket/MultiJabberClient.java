package com.net.serversocket;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-25 12:10
 */
public class MultiJabberClient {

    static final int MAX_THREADS = 40;

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress addr = InetAddress.getByName(null);
        while (true) {
            if (JabberClientThread.threadCount() < MAX_THREADS) {
                new JabberClientThread(addr);
            }
            Thread.sleep(100);
        }
    }
}
