package com.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    public static String aa = "111111111";
    public Integer id;
    public String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String args[]) throws Exception {
        String file = "student.ser";
        // Serializable  序列化
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(new Student(123, "Jacky"));
        outputStream.close();
        // Deserializable  反序列化
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Student a = (Student) inputStream.readObject();
        System.out.println(a.aa);
        inputStream.close();
    }
}  
