package com.DataStructures;

import java.util.Iterator;

/**
 * @Description:
 * @author: zhuzz
 * @date: 2018-09-11 12:17
 */
public class TestDemo {
    public static void main(String[] args) {
        LinkedListDemo<Person> list = new LinkedListDemo<Person>();
        //往链表中加入10个元素
        for(int i=0; i<10;i++){
            Person p = new Person("zhang"+i, "m");
            list.add(p);
        }
        list.print();
        System.out.println("========");
        Person p = new Person("zhang1", "m");
        list.remove(p);//移除自定的元素
        list.print();
        System.out.println("========");
        Person p1 = new Person("zhang4", "m");
        Iterator<Person> iterator = list.iterator();
        while(iterator.hasNext()){
            Person person = iterator.next();
            if(person.equals(p1)){
                iterator.remove();//迭代器移除制定元素
                break;
            }
        }
        list.print();
    }
}
