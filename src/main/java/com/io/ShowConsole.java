package com.io;

import java.io.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-30 17:47
 */
public class ShowConsole {
    public static void main(String[] args) throws IOException {
        String path = "D:\\hello.txt";
        System.out.println("1、-------FileInputStream输入中文出现乱码-------");
        test01(path);
        System.out.println("\n2、-----解决FileInputStream输入中文出现乱码----\n");
        test02(path);
        System.out.println("\n3、---------FileReader输入------------\n");
        test03(path);
        System.out.println("\n4、-------利用转换流包裹字节流输入-----\n");
        test04(path);
        System.out.println("\n5、-在test04的基础上加增强缓冲流，加快读取速度-\n");
        test05(path);

    }
    /*
     * 情况一：字节流输入 FileInputStream ，中文出现乱码，这里没有解码。
     */
    public static void test01(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        int len = 0;
        while ((len = is.read()) != -1) {
            System.out.print((char)len);
        }
        is.close();
    }
    /*
     * 情况二：字节流输入 FileInputStream ，解决中文出现乱码问题
     */
    public static void test02(String path) throws IOException{
        InputStream is = new FileInputStream(path);
        int len = 0;
		/*将文件数据全部接收到数组buffer中,再控制台输出,保证了接收的中文字节数不会失帧。
		GBK每个汉字两个字节，而UTF-8每个汉字三个，假如在接收一个中文字符时，
		只接收了中文字符的一个字节就开始输出，那么那个中文字符就会失帧，所以就会乱码*/
        byte[] buffer = new byte[is.available()];
        while ((len = is.read(buffer)) != -1) {
            System.out.print(new String(buffer,0,len));
        }
        is.close();
    }
    /*
     * 情况三：字符流输入 FileReader 继承了 InputStreamReader，
     * 每次都是接收两个字节，因此中文(占两个字节)绝不会乱码。
     * 但要注意读取的文本的编码格式要与源程序的解码格式一致。
     */
    public static void test03(String path) throws IOException{
        Reader reader = new FileReader(path);
        int len = 0;
        char[] cbuf = new char[1024];//缓冲
        while ((len = reader.read(cbuf)) != -1) {
            System.out.print(new String(cbuf,0,len));
        }
    }
    /*
     * 情况四：利用转换流,将字节流转换为字符流(InputStreamReader)包裹字节流输入[内建缓冲区，8192个字节，
     具有预读功能]，改变其解码方式(可以自由设置解码方式)
     */
    public static void test04(String path) throws IOException{
        Reader reader = new InputStreamReader(new FileInputStream(path),"UTF-8");
        int len = 0;
        char[] cbuf = new char[11];
        while ((len = reader.read(cbuf)) != -1) {
            System.out.print(new String(cbuf,0,len));
        }
    }
    /*
     * 在test04的基础上加增强缓冲流，加快读取速度
     */
    public static void test05(String path) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        int len = 0;
        while ((len = reader.read()) != -1) {
            System.out.print((char)len);
        }
    }
    /*
     * 在test04的基础上加增强缓冲流，加快读取速度
     */
    /*public static void test05(String path) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        int len = 0;
        while ((len = reader.read()) != -1) {
            System.out.print((char)len);
        }
    }*/
}
