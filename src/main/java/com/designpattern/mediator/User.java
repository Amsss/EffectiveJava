package com.designpattern.mediator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:40
 */
public abstract class User {

    private Mediator mediator;

    public Mediator getMediator() {
        return mediator;
    }

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void work();
}
