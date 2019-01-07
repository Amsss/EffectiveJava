package com.designpattern.iterator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:39
 */
public class Test {

    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
