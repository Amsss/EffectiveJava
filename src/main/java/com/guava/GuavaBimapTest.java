package com.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @description: BiMap是一种特殊的映射其保持映射，同时确保没有重复的值是存在于该映射和一个值可以安全地用于获取键背面的倒数映射
 * @author: zhuzz
 * @date: 2018-09-28 15:12
 */
public class GuavaBimapTest {
    public static void main(String args[]){
        BiMap<Integer, String> empIDNameMap = HashBiMap.create();

        empIDNameMap.put(new Integer(101), "Mahesh");
        empIDNameMap.put(new Integer(102), "Sohan");
        empIDNameMap.put(new Integer(103), "Ramesh");
        empIDNameMap.put(106, null);

        //Emp Id of Employee "Mahesh"
        System.out.println(empIDNameMap.inverse().get(null));
        System.out.println(empIDNameMap.values());
    }
}
