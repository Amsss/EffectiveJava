package com.WebService.services;

import javax.xml.ws.Endpoint;

/**
 * @Author: Zezhao.Zhu
 * @Description: 发布Webservice
 * @Date: 14:38 2018/5/9
 */
public class ServerStart {
    public static void main(String[] args) {
        String address = "http://127.0.0.1:8444/webService";
        Endpoint.publish(address, new WebServiceImpl());
        System.out.print("Webservice：" + address + "?wsdl发布成功");
    }
}
