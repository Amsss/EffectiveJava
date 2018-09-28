package com.DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Description: 链表类
 * @author: zhuzz
 * @date: 2018-09-11 12:15
 */
public class LinkedListDemo<T> {

    private Node<T> head;//头结点

    private Node<T> tail;//尾节点

    private int size;//链表大小

    public LinkedListDemo(){
        head = new Node<T>(null, null, null);
        tail = new Node<T>(null, head, null);
        head.setNext(tail);
        size = 0;
    }

    public MyIterator<T> iterator(){
        return new MyIterator<T>();
    }

    public void add(T data){
        Node<T> node = new Node<T>(data);
        node.setPre(tail.getPre());
        tail.getPre().setNext(node);
        tail.setPre(node);
        node.setNext(tail);
        size++;
    }

    public void remove(T data){
        Node<T> node = head;
        while(tail != node.getNext()){
            Node<T> currentNode = node.getNext();
            if(currentNode.getData().equals(data)){
                currentNode.getPre().setNext(currentNode.getNext());
                currentNode.getNext().setPre(currentNode.getPre());
                size--;
                break;
            }
            node = currentNode;
        }
    }

    public void print(){
        Node<T> node = head;
        while(tail != node.getNext()){
            Node<T> currentNode = node.getNext();
            System.out.println(currentNode.getData().toString());
            node = currentNode;
        }
    }

    /**
     *
     * 项目名： adt
     * 类名： LinkedListDemo.java
     * 类描述： 定义一个该链表的迭代器来访问
     * 备注：
     * 创建日期：2014-10-10
     * 创建时间：上午12:10:46
     * @param <T>
     */
    @SuppressWarnings("hiding")
    private class MyIterator<T> implements Iterator<T> {

        @SuppressWarnings("unchecked")
        private Node<T> currentNode = (Node<T>) head.getNext();//节点读取当前位置

        private Node<T> returnedNode = currentNode;//返回节点的位置

        @Override
        public boolean hasNext() {
            return currentNode == tail? false:true;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new IndexOutOfBoundsException();
            }
            returnedNode = currentNode;
            currentNode = currentNode.getNext();
            return returnedNode.getData();
        }

        @Override
        public void remove() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            returnedNode.getPre().setNext(returnedNode.getNext());
            returnedNode.getNext().setPre(returnedNode.getPre());
            returnedNode = returnedNode.getNext();
            currentNode = returnedNode;
            size--;
        }
    }
}
