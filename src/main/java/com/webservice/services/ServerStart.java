package com.webservice.services;

import javax.xml.ws.Endpoint;

/**
 * @description: 发布Webservice
 * @author: zhuzz
 * @date: 2019/1/4 11:09
 */
public class ServerStart {
    public static void main(String[] args) {
        String address = "http://127.0.0.1:8444/webService";
        Endpoint.publish(address, new WebServiceImpl());
        System.out.print("Webservice：" + address + "?wsdl发布成功");
    }
}
