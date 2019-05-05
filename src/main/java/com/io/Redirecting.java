package com.io;

import java.io.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-05-05 12:14
 */
public class Redirecting {
    public static void main(String[] args) {
        try {
            BufferedInputStream in =
                    new BufferedInputStream(
                            new FileInputStream(
                                    "C:/MyProject/EffectiveJava/src/main/java/com/io/Redirecting.java"));
            // Produces deprecation message:
            PrintStream out =
                    new PrintStream(
                            new BufferedOutputStream(
                                    new FileOutputStream("test.out")));
            System.setIn(in);
            System.setOut(out);
            System.setErr(out);
            BufferedReader br =
                    new BufferedReader(
            new InputStreamReader(System.in));
            String s;
            while((s = br.readLine()) != null) {
                System.out.println(s);
            }
            out.close(); // Remember this!
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
