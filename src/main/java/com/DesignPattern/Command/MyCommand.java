package com.DesignPattern.Command;

public class MyCommand implements Command {  
	  
    private Receiver receiver;  
      
    public MyCommand(Receiver receiver) {  
        this.receiver = receiver;  
    }  
  
    public void exe() {
        receiver.action();  
    }  
}
