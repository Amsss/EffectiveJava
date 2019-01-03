package com.concurrent.Synchronized.waitandnotify;

public class Test {
    public static void main(String[] args) {
        Goods goods = new Goods();

        //生产者生产商品
        Producer p = new Producer();
        p.setGoods(goods);

        //消费者取走商品
        Customer c = new Customer();
        c.setGoods(goods);

        new Thread(p).start();
        new Thread(c).start();
    }
}
