package com.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-11 16:06
 */
public class Compete {
    static final int SIZE = 5000;

    public static void main(String[] args) {
        Thing2[] a = new Thing2[SIZE];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Thing2();
        }
        Thing4[] b = new Thing4[SIZE];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Thing4();
        }
        try {
            long t1 = System.currentTimeMillis();
            ByteArrayOutputStream buf =
                    new ByteArrayOutputStream();
            ObjectOutputStream o =
                    new ObjectOutputStream(buf);
            for (int i = 0; i < a.length; i++) {
                o.writeObject(a[i]);
            }
            // Now get copies:
            ObjectInputStream in =
                    new ObjectInputStream(
                            new ByteArrayInputStream(
                                    buf.toByteArray()));
            Thing2[] c = new Thing2[SIZE];
            for (int i = 0; i < c.length; i++) {
                c[i] = (Thing2) in.readObject();
            }
            long t2 = System.currentTimeMillis();
            System.out.println(
                    "Duplication via serialization: " +
                            (t2 - t1) + " Milliseconds");
            // Now try cloning:
            t1 = System.currentTimeMillis();
            Thing4[] d = new Thing4[SIZE];
            for (int i = 0; i < d.length; i++) {
                d[i] = (Thing4) b[i].clone();
            }
            t2 = System.currentTimeMillis();
            System.out.println(
                    "Duplication via cloning: " +
                            (t2 - t1) + " Milliseconds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
