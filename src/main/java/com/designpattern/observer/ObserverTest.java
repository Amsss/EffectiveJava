package com.designpattern.observer;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:51
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
