package com.DesignPattern.Visitor;

public class MyVisitor implements Visitor {  
	  
    public void visit(Subject sub) {
        System.out.println("visit the subject："+sub.getSubject());  
    }  
}
