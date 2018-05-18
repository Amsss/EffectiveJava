package com.DesignPattern.FactoryMethod;

import com.DesignPattern.Builder.MailSender;
import com.DesignPattern.Builder.Sender;
import com.DesignPattern.Builder.SmsSender;

public class SendFactory {
	public static Sender produceMail(){  
        return new MailSender();  
    }  
      
    public static Sender produceSms(){  
        return new SmsSender();  
    }
}
