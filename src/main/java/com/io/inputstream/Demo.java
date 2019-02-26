package com.io.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-02-25 14:36
 */
public class Demo {

    /**
     * 字节流 读文件内容
     *
     * @throws IOException
     */
    private static void test1() throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[3];
        in.read(b);
        in.close();
        System.out.println(new String(b));
    }

    public static void main(String[] args) throws IOException {
        test1();
    }
}
