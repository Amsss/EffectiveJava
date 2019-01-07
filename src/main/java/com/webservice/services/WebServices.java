package com.webservice.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 12:10
 */
@WebService
public interface WebServices {

    /**
     * @param name
     * @return
     */
    @WebMethod
    String sayHello1(String name);

    /**
     *
     * @param name
     * @return
     */
    @WebMethod
    String sayHello2(String name);

    /**
     *
     * @param name
     * @return
     */
    @WebMethod
    String sayHello3(String name);
}
