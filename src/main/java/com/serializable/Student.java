package com.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
}  
