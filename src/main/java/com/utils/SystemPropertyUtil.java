package com.utils;

import java.time.LocalTime;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-08-14 14:48
 */
public class SystemPropertyUtil {

    public static void main(String[] args) {
        System.setProperty("now", LocalTime.now().plusHours(-1).toString());
        System.out.println(LocalTime.now());
        String osName = System.getProperty("os.name");
        System.out.println(osName);
    }
}
