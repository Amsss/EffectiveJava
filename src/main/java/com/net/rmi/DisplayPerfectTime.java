package com.net.rmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-04 22:37
 */
public class DisplayPerfectTime {
    public static void main(String[] args) {
        //System.setSecurityManager(new RMISecurityManager());
        try {
            PerfectTimeI t =
                    (PerfectTimeI) Naming.lookup(
                            "//colossus:2005/PerfectTime");
            for(int i = 0; i < 10; i++) {
                System.out.println("Perfect time = " +
                        t.getPerfectTime());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
