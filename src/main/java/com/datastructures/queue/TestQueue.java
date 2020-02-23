package com.datastructures.queue;

import com.datastructures.Person;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-09-11 12:18
 */
public class TestQueue {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Queue queue1 = new LinkedList<String>();
        QueueDemo<Person> queue = new QueueDemo<Person>();
        for (int i = 0; i < 100; i++) {
            Person p = new Person("zhang" + i, "m");
            queue.add(p);
        }
        queue.print();
        System.out.println("=====");
        //依次删除队列头元素
        while (queue.size() > 0) {
            queue.remove();
            queue.print();
            System.out.println("=====");
        }
    }

}
