package com.net.datagramsocket;

import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * @description: 1、“用户数据报协议”（UDP） 它并不刻意追求数据包会完全发送出去，
 * 也不能担保它们抵达的顺序与它们发出时一样。我们认为这是一种“不可靠协议”
 * 2、对数据报来说，我们在客户和服务器程序都可以放置一个 DatagramSocket（数据报套接字）
 * @author: zhuzz
 * @date: 2019-06-25 12:17
 */
public class Dgram {
    public static DatagramPacket toDatagram(String s, InetAddress destIA, int destPort) {
        // Deprecated in Java 1.1, but it works:
        byte[] buf = new byte[s.length() + 1];
        s.getBytes(0, s.length(), buf, 0);
        // The correct Java 1.1 approach, but it's
        // Broken (it truncates the String):
        // byte[] buf = s.getBytes();
        return new DatagramPacket(buf, buf.length, destIA, destPort);
    }

    public static String toString(DatagramPacket p) {
        // The Java 1.0 approach:
        // return new String(p.getData(),
        // 0, 0, p.getLength());
        // The Java 1.1 approach:
        return new String(p.getData(), 0, p.getLength());
    }
}
