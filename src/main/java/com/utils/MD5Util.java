package com.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description: 获取MD5加密结果
 * @author: zhuzz
 * @date: 2018-12-27 10:25
 */
public class MD5Util {

    /**
     * 利用java原生的摘要实现MD5加密
     *
     * @param text 加密后的报文
     * @return
     */
    private static String getMD5StrJava(String text) {
        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(text.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                // 加盐
                int number = b & 0xff;
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        String aa = "111111111";
        System.out.println(MD5Util.getMD5StrJava(aa));
    }
}
