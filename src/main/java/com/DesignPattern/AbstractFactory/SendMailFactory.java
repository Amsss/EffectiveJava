package com.DesignPattern.AbstractFactory;

public class SendMailFactory implements Provider{

	public Sender produce() {
		return new MailSender();
	}

}
