package com.datastructures.hash;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-12-27 9:53
 */
public class Test {

    public static void main(String[] args) {
        String AA = "11111";
        int a = 111;

        System.out.println(hash(AA));

    }
    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
