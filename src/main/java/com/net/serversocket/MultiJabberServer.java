package com.net.serversocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-25 11:58
 */
public class MultiJabberServer {
    static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server Started");
        try {
            while (true) {
                // Blocks until a connection occurs:
                Socket socket = s.accept();
                try {
                    new ServeOneJabber(socket);
                } catch (IOException e) {
                    // If it fails, close the socket,
                    // otherwise the thread will close it:
                    socket.close();
                }
            }
        } finally {
            s.close();
        }
    }
}
