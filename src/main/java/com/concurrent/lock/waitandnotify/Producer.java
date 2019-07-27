package com.concurrent.lock.waitandnotify;

public class Producer implements Runnable {
    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (goods) {
                if (goods.getNum() > 0) {
                    try {
                        goods.wait();//商品数量已经大于0啦,消费者要取货咯,自己就开始等待咯
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (i % 2 == 0) {
                    goods.setPinpai("哇哈哈");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    goods.setName("矿泉水");

                } else {
                    goods.setPinpai("旺仔");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    goods.setName("小馒头");
                }
                goods.setNum((goods.getNum() + 1));
                System.out.println("生产了" + goods.getPinpai() + goods.getName());
                goods.notify();//商品不够啦,自己生产完,然后通知消费者取货咯
            }
        }
    }

}
