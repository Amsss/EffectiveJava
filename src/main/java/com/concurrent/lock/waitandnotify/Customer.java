package com.concurrent.lock.waitandnotify;

public class Customer implements Runnable {

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
                if (goods.getNum() <= 0) {
                    try {
                        //如果商品生产的数量小于0,则开始等待.只有有货才能购物嘛
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goods.setNum((goods.getNum() - 1));
                System.out.println("取走了" + goods.getPinpai() + goods.getName());
                //取走之后通知生产商继续生产商品(唤醒在对象锁等待池中的线程继续执行)
                goods.notify();
            }
        }
    }

}
