package com.DesignPattern.FactoryMethod;

import com.DesignPattern.Builder.Sender;

public class Test {
	public static void main(String[] args) {
		Sender sender = SendFactory.produceMail();  
        sender.Send();
	}
}
