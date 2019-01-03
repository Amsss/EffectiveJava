package com.webservice.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * SEI
 * @author admin
 * @类功能说明:
 */
@WebService
public interface WebServices {
	
	@WebMethod
	String sayHello1(String name);
	
	@WebMethod
	String sayHello2(String name);
	
	@WebMethod
	String sayHello3(String name);
}
