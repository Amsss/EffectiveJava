package com.net.serversocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @description: 客户程序的源码
 * @author: zhuzz
 * @date: 2019-06-24 19:48
 */
public class JabberClient {
    public static void main(String[] args) throws IOException {
        // Passing null to getByName() produces the
        // special "Local Loopback" IP address, for
        // testing on one machine w/o a network:
        InetAddress addr = InetAddress.getByName(null);
        // Alternatively, you can use
        // the address or name:
        // InetAddress addr = InetAddress.getByName("127.0.0.1");
        // InetAddress addr = InetAddress.getByName("localhost");
        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, JabberServer.PORT);
        // Guard everything in a try-finally to make
        // sure that the socket is closed:
        try {
            System.out.println("socket = " + socket);
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
            // Output is automatically flushed
            // by PrintWriter:
            PrintWriter out =
                    new PrintWriter(
                            new BufferedWriter(
                                    new OutputStreamWriter(
                                            socket.getOutputStream())), true);
            for (int i = 0; i < 10; i++) {
                out.println("howdy " + i);
                String str = in.readLine();
                System.out.println(str);
            }
            out.println("END");
        } finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}
