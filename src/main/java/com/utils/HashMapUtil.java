package com.utils;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @description: Map工具类
 * @author zhuzz
 * @date: 2017-10-27 上午10:31:04
 */
public class HashMapUtil<K, V> extends HashMap<K, V> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private HashMapUtil() {
    }

    public static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<>(16);
    }

    public static void main(String[] args) {
        DecimalFormat DECIMAL_FORMAT1 = new DecimalFormat("0.00%");
        System.out.println(DECIMAL_FORMAT1.format(1));
        DecimalFormat DECIMAL_FORMAT2 = new DecimalFormat("0.00");
        System.out.println(DECIMAL_FORMAT2.format(1));
        Map<String, Object> map2 = new HashMap<String, Object>(16) {
            {
                put("11", "22");
            }
        };
        Double b  = Double.valueOf(10)/3;
        System.out.println(b);
        Map<String, Object> map1 = new HashMap<>(16);
        map1.put("11", "222");
        Double a = -1.00 / 1.00;
        System.out.println(a.isNaN());
        /*System.out.println(map1);
        Map<String, Object> map = HashMapUtil.newInstance();
        map.put("Test", 1);
        map.put("B", 2);
        map.put("C", 3);
        //测试Jdk1.8特性 Lambda
        map.forEach((k, v) -> {
            if ("C".equals(k)) {
                System.out.println("Hello E");
            }
        });
        System.out.println(map);*/
    }
}
