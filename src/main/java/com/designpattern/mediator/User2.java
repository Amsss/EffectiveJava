package com.designpattern.mediator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:41
 */
public class User2 extends User {

    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe!");
    }
}
