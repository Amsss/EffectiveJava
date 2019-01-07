package com.enums;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 12:03
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Planet.MERCURY.surfaceGravity());
        System.out.printf("Weight on %s is %f%n", Planet.MERCURY, Planet.MERCURY.surfaceGravity());
        System.out.println(Planet.MERCURY.name());
        Map map = new Hashtable(16);
        Map mapa = new HashMap(16);
        Map mapc = new ConcurrentHashMap(16);
    }
}
