package com.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-26 11:39
 */
public class CloneUtil {

    private CloneUtil() {
    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Map<String, Object>> map = new ArrayList<>(16);
        Map<String, Object> ma1 = new HashMap<>(16);
        ma1.put("111", "22");
        map.add(ma1);
        List<Map<String, Object>> map2 = deepCopy(map);
        Map<String, Object> ma2 = map2.get(0);
        ma2.put("111", "222");
        map2.clear();
    }
}
