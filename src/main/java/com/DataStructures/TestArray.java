package com.DataStructures;

/**
 * @Description:
 * @author: zhuzz
 * @date: 2018-09-11 12:13
 */
public class TestArray {
    public static void main(String[] args) {
        ArrayDemo<Person> array = new ArrayDemo<>();
        Person p = new Person("张三", "m");
        array.insert(p, 0);
        array.trans();
        array.delete(0);
        System.out.println("---");
        array.trans();
    }
}
