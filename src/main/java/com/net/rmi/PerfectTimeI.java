package com.net.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-04 22:16
 */
public interface PerfectTimeI  extends Remote {
    long getPerfectTime() throws RemoteException;
}
