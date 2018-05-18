package com.DesignPattern.AbstractFactory;

public class SendSmsFactory implements Provider{

	public Sender produce() {
		return new SmsSender();
	}

}
