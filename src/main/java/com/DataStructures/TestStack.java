package com.DataStructures;

/**
 * @Description:
 * @author: zhuzz
 * @date: 2018-09-11 12:19
 */
public class TestStack {

    /**
     * @param args
     */
    public static void main(String[] args) {
        StackDemo<Person> queue = new StackDemo<>();
        for(int i=0; i<10; i++){
            Person p = new Person("zhang"+i, "m");
            queue.add(p);
        }
        queue.print();
        System.out.println("=====");
        while(queue.size() > 0){
            queue.remove();
            queue.print();
            System.out.println("=====");
        }
    }
}
