package com.framework.control;

/**
 * @description: 控制类
 * @author: zhuzz
 * @date: 2019-04-24 18:06
 */
public class Controller {
    /**
     *
     */
    private EventSet es = new EventSet();

    public void addEvent(AbstractEvent c) {
        es.add(c);
    }

    public void run() {
        AbstractEvent e;
        while ((e = es.getNext()) != null) {
            if (e.ready()) {
                e.action();
                System.out.println(e.description());
                es.removeCurrent();
            }
        }
    }
}
