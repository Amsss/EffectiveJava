package com.zhuzz.util;

import java.util.*;

/**
 * 类型推导
 *@author zhuzz
 * @类功能说明:工具类
 * @创建时间:2017-10-27 上午10:31:04
 */
public class HashMapUtil<K, V> extends HashMap<K, V>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//单实例构造方法 
	private HashMapUtil() {

	}
	public static <K ,V> HashMap<K, V> newInstance() {
		return new HashMap<K, V>();
	}
	
	public static void main(String[] args) {
		Map<String, Object> map = HashMapUtil.newInstance();
		map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.forEach((k,v)->{if("C".equals(k)){
            System.out.println("Hello E");
        }});
		System.out.println(map);
	}
}
