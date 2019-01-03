package com.DesignPattern.AbstractFactory;

public class SmsSender implements Sender {

	public void Send() {
		System.out.println("this is sms sender!");
	}

}
