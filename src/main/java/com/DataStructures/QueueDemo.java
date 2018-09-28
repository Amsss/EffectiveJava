package com.DataStructures;

import java.util.Arrays;

/**
 * @Description:
 * @author: zhuzz
 * @date: 2018-09-11 12:17
 */
public class QueueDemo<T> {

    private Object[] object;

    /**
     * 队列容量
     */
    private int capicity;

    /**
     * 队列中元素的个数
     */
    private int size;

    private final static int DEFAULT_CAPICAL = 10;

    public QueueDemo(){
        capicity = DEFAULT_CAPICAL;
        object = new Object[capicity];
    }

    public QueueDemo(int capicity){
        this.capicity = capicity;
        object = new Object[this.capicity];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 往队列中添加元素
     * @param t
     */
    public void add(T t){
        if(size == capicity){
            throw new IndexOutOfBoundsException("queue is full");
        }
        object[size++]=t;
    }

    /**
     * 移除队列中的元素
     */
    public void remove(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("queue is empty");
        }
        for(int pos = 0; pos < size-1; pos++){//将整个数组往前以一个位置
            object[pos] = object[pos+1];
        }
        size--;
    }

    public void clear(){
        Arrays.fill(object, null);
        size=0;
    }

    public void print(){
        for(int i=0; i<size; i++){
            System.out.println(object[i].toString());
        }
    }
}
