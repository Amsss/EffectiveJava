package com.java8.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-04 23:57
 */
public class CreatingStreams {
    public static void main (String[] args){
        Comparator cmp=new ComparatorFactory().makeComparator();
        int i=10;
        int j =-5;
        System.out.println(cmp.compare(i, j));

        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(cmp);
            obs.close();
            System.out.println("a");
            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cmp = (Comparator)ois.readObject();
            ois.close();
            System.out.println("b");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("c");
        }
        System.out.println(cmp.compare(i, j));
    }
}
