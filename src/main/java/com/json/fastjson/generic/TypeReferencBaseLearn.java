package com.json.fastjson.generic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-22 13:46
 */
public class TypeReferencBaseLearn {

    public static class IntMap extends HashMap<String, Integer> {
    }

    void test1() {
        IntMap intMap = new IntMap();
        System.out.println("getSuperclass:" + intMap.getClass().getSuperclass());
        System.out.println("getGenericSuperclass:" + intMap.getClass().getGenericSuperclass());
        Type type = intMap.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType p = (ParameterizedType) type;
            for (Type t : p.getActualTypeArguments()) {
                System.out.println(t);
            }
        }
    }

    void test2() {
        Map<String, Integer> intMap = new HashMap<>(16);
        System.out.println("getSuperclass:" + intMap.getClass().getSuperclass());
        System.out.println("getGenericSuperclass:" + intMap.getClass().getGenericSuperclass());
        Type type = intMap.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType p = (ParameterizedType) type;
            for (Type t : p.getActualTypeArguments()) {
                System.out.println(t);
            }
        }
    }

    void test3() {
        Map<String, Integer> intMap = new HashMap<String, Integer>(16) {
        };
        System.out.println("getSuperclass:" + intMap.getClass().getSuperclass());
        System.out.println("getGenericSuperclass:" + intMap.getClass().getGenericSuperclass());
        Type type = intMap.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType p = (ParameterizedType) type;
            for (Type t : p.getActualTypeArguments()) {
                System.out.println(t);
            }
        }
    }

    public static <T> Response<T> parseToMap(String json, Class<T> type) {
        return JSON.parseObject(json, new TypeReference<Response<T>>(type) {
        });
    }

    public static <K, V> Map<K, V> parseToMap(String json, Class<K> keyType, Class<V> valueType) {
        return JSON.parseObject(json, new TypeReference<Map<K, V>>(keyType, valueType) {
        });
    }

    public static void main(String[] args) {
        String json = "{1:{name:\"ddd\"},2:{name:\"zzz\"}}";
        Map<Integer, Model> map = parseToMap(json, Integer.class, Model.class);
        System.out.println(map.get(1).name);
        System.out.println(map.get(2).name);
        TypeReferencBaseLearn obj = new TypeReferencBaseLearn();
        obj.test1();
        System.out.println("===========分隔符===========");
        obj.test2();
        System.out.println("===========分隔符===========");
        obj.test3();
        System.out.println("===========分隔符===========");
        List<Integer> list = new ArrayList<>(16);
        list.add(1);
        list.add(9);
        list.add(4);
        list.add(8);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("a", list);
        System.out.println(jsonObj);
        new Runnable() {


            @Override
            public void run() {

            }
        };
        new Thread() {
        };


        List<String> list2 = jsonObj.getObject("a", new TypeReference<List<Integer>>() {
        });
        System.out.println(list2);
    }
}
