package com.rpc;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-09-18 11:37
 */
public class RpcTest {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                RpcExporter.exporter("localhost", 8088);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        RpcImporter importer = new RpcImporter<EchoService>();
        EchoService echoService = (EchoService) importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
        System.out.println(echoService.echo("Are you ok ?"));
        System.out.println(echoService.echo("Are you ok ?"));
        System.out.println(echoService.echo("Are you ok ?"));
        System.out.println(echoService.echo("Are you ok ?"));
        System.out.println(echoService.echo("Are you ok ?"));
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(echoService.echo("Are you ok ?11111"));
    }
}
