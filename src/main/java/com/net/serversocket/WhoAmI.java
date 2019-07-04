package com.net.serversocket;

import java.net.InetAddress;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-24 19:47
 */
public class WhoAmI {
    public static void main(String[] args)
         throws Exception {
        if(args.length != 1) {
            System.err.println("Usage: WhoAmI MachineName");
            System.exit(1);
        }
        InetAddress a = InetAddress.getByName(args[0]);
        System.out.println(a);
    }
}
