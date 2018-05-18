package com.DesignPattern.Visitor;

public interface Subject {  
    void accept(Visitor visitor);
    String getSubject();
}
