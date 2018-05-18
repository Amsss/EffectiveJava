package com.WebService.client;

public class ClientTest {

	/**
	 * @方法说明：
	 * @param args
	 */
	public static void main(String[] args) {
		MyWebServiceImplService factory = new MyWebServiceImplService();
		MyWebServiceImpl MyWebService = factory.getMyWebServiceImplPort();
		String result = MyWebService.sayHello("jack");
	}

}
