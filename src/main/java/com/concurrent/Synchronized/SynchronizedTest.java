package com.concurrent.Synchronized;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedTest {

    Thread t1 = new Thread(new Runnable() {

        @Override
        public void run() {

            MyClass.log1("msg11", "msg12");
        }
    });
    Thread t2 = new Thread(new Runnable() {

        @Override
        public void run() {

            MyClass.log2("msg21", "msg22");
        }
    });
    Thread t3 = new Thread(new Runnable() {

        @Override
        public void run() {

            MyClass.log3("msg31", "msg32");
        }
    });

    Thread t4 = new Thread(new Runnable() {

        @Override
        public void run() {

            new MyClass().log4("msg41", "msg42");
        }
    });

    Thread t5 = new Thread(new Runnable() {

        @Override
        public void run() {

            new MyClass().log5("msg51", "msg52");
        }
    });

    Thread t6 = new Thread(new Runnable() {

        @Override
        public void run() {

            new MyClass().log6("msg61", "msg62");
        }
    });

    public static void main(String[] args) {
        SynchronizedTest st = new SynchronizedTest();
        AtomicInteger a = new AtomicInteger();
        st.t1.start();
        //st.t3.start() ;
        //st.t2.start() ;
        st.t4.start();
        //st.t5.start();
        //st.t6.start();
        int i = 0;
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("---------------> " + i);
                i++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i > 10) {
                break;
            }
        }

    }

}

