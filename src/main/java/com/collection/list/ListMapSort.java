package com.collection.list;

import java.util.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-01 17:27
 */
public class ListMapSort {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "p");
        map1.put("cj", "5");
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("name", "h");
        map2.put("cj", "12");
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("name", "f");
        map3.put("cj", "31");
        list.add(map1);
        list.add(map3);
        list.add(map2);
        //排序前
        for (Map<String, Object> map : list) {
            System.out.println(map.get("cj"));
        }
        Collections.sort(list, (o1, o2) -> {
            //name1是从你list里面拿出来的一个
            Integer name1 = Integer.valueOf(o1.get("cj").toString());
            //name1是从你list里面拿出来的第二个name
            Integer name2 = Integer.valueOf(o2.get("cj").toString());
            return name1.compareTo(name2);
        });
        //排序后
        System.out.println("-------------------");
        for (Map<String, Object> map : list) {
            System.out.println(map.get("cj"));
        }
    }
}
