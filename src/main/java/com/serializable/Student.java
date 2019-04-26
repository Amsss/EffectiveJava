package com.serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 序列化
 * @author: zhuzz
 * @date: 2019/1/3 16:23
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    public String aa = "111111111";
    public Integer id;
    public String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
        List<Map<String,Object>> map = new ArrayList<>(16);
        Map<String, Object> ma1 = new HashMap<>();
        ma1.put("111","22");
        map.add(ma1);
        List<Map<String,Object>> map2 = deepCopy(map);
        Map<String,Object> ma2 = map2.get(0);
        ma2.put("111","222");
        map2.clear();

        String file = "student.ser";
        // Serializable  序列化
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(new Student(123, "Jacky"));
        outputStream.close();
        // Deserializable  反序列化
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Student student = (Student) inputStream.readObject();
        System.out.println(student.aa);
        inputStream.close();
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
}  
