package com.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-05-05 9:59
 */
public class Echo {
    public static void main(String[] args) {
        DataInputStream in =
                new DataInputStream(
                        new BufferedInputStream(System.in));
        String s;
        try {
            while ((s = in.readLine()).length() != 0) {
                System.out.println(s);
            }
            // An empty line terminates the program
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
