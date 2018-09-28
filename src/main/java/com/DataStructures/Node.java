package com.DataStructures;

/**
 * @Description: 节点类
 * @author: zhuzz
 * @date: 2018-09-11 12:14
 */
public class Node<T> {

    private T data;

    private Node<T> pre;

    private Node<T> next;

    public Node(){
        super();
        this.pre = null;
        this.next = null;
    }

    public Node(T data){
        super();
        this.data = data;
        this.pre = null;
        this.next = null;
    }

    public Node(T data, Node<T> pre, Node<T> next){
        super();
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPre() {
        return pre;
    }

    public void setPre(Node<T> pre) {
        this.pre = pre;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
