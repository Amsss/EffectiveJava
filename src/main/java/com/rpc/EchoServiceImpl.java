package com.rpc;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-09-18 10:43
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String ping) {
        return ping != null ? ping + " --> I am ok." : " I am ok.";
    }
}
