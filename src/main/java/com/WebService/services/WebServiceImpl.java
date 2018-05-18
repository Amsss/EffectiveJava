package com.WebService.services;

import javax.jws.WebService;

/**
 * SEI实现
 * @类功能说明:
 */
@WebService
public class WebServiceImpl implements WebServices {

	public String sayHello1(String name) {
		return "Hello"+name;
	}
	
	public String sayHello2(String name) {
		return "";
	}
	
	public String sayHello3(String name) {
		return null;
	}
	
}
