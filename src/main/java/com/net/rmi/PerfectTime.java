package com.net.rmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-04 22:18
 */
public class PerfectTime extends UnicastRemoteObject implements PerfectTimeI {
    // Implementation of the interface:
    @Override
    public long getPerfectTime() throws RemoteException {
        return System.currentTimeMillis();
    }

    // Must implement constructor to throw
    // RemoteException:
    public PerfectTime() throws RemoteException {
        // Called automatically
        // super();
    }

    // Registration for RMI serving:
    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
        try {
            PerfectTime pt = new PerfectTime();
            Naming.bind("PerfectTime", pt);
            System.out.println("Ready to do time");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
