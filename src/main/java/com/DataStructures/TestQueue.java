package com.DataStructures;

/**
 * @Description:
 * @author: zhuzz
 * @date: 2018-09-11 12:18
 */
public class TestQueue {

    /**
     * @param args
     */
    public static void main(String[] args) {
        QueueDemo<Person> queue = new QueueDemo<Person>();
        for(int i=0; i<10; i++){
            Person p = new Person("zhang"+i, "m");
            queue.add(p);
        }
        queue.print();
        System.out.println("=====");
        while(queue.size() > 0){//依次删除队列头元素
            queue.remove();
            queue.print();
            System.out.println("=====");
        }
    }

}
