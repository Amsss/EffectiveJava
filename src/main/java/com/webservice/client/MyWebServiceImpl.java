package com.webservice.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * @description: This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * @author: zhuzz
 * @date: 2019/4/22 11:18
 */
@WebService(name = "myWebServiceImpl", targetNamespace = "http://impl.service.serialization.zhuzz.com/")
@XmlSeeAlso({ObjectFactory.class})
public interface MyWebServiceImpl {


    /**
     * @param arg0 1
     * @return returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://impl.service.serialization.zhuzz.com/", className = "com.zhuzz.serialization.service.impl.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://impl.service.serialization.zhuzz.com/", className = "com.zhuzz.serialization.service.impl.SayHelloResponse")
    @Action(input = "http://impl.service.serialization.zhuzz.com/myWebServiceImpl/sayHelloRequest", output = "http://impl.service.serialization.zhuzz.com/myWebServiceImpl/sayHelloResponse")
    String sayHello(@WebParam(name = "arg0", targetNamespace = "") String arg0);
}
