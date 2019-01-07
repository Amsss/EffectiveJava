package com.webservice.client;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 12:09
 */
public class ClientTest {

    /**
     * @param args
     * @方法说明：
     */
    public static void main(String[] args) {
        MyWebServiceImplService factory = new MyWebServiceImplService();
        MyWebServiceImpl MyWebService = factory.getMyWebServiceImplPort();
        String result = MyWebService.sayHello("jack");
    }

}
