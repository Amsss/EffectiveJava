package com.compare;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Com implements Comparable<String> {

    public int compareTo(String o) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static void main(String[] args) {

        Date a = new Date();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date b = new Date();
        boolean aa = b.after(a);
        System.out.println(aa);
    }
}
