package com.datastructures.queue;

import java.util.Arrays;

/**
 * @description: 循环队列的顺序存储结构实现
 * @author: zhuzz
 * @date: 2018-12-26 16:57
 */
public class LoopQueue<E> {

    public Object[] data = null;
    /**
     * 队列容量
     */
    private int maxSize;
    /**
     * 队列尾，允许插入
     */
    private int rear;
    /**
     * 队列头，允许删除
     */
    private int front;
    /**
     * 队列当前长度
     */
    private int size = 0;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = rear = 0;
        } else {
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
    }

    // 判空
    public boolean empty() {
        return size == 0;
    }

    // 插入
    public boolean add(E e) {
        if (size == maxSize) {
            throw new RuntimeException("队列已满，无法插入新的元素！");
        } else {
            data[rear] = e;
            rear = (rear + 1) % maxSize;
            size++;
            return true;
        }
    }

    // 返回队首元素，但不删除
    public E peek() {
        if (empty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            return (E) data[front];
        }
    }

    // 出队
    public E poll() {
        if (empty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            // 保留队列的front端的元素的值
            E value = (E) data[front];
            // 释放队列的front端的元素
            data[front] = null;
            //队首指针加1
            front = (front + 1) % maxSize;
            size--;
            return value;
        }
    }

    // 队列长度
    public int length() {
        return size;
    }

    //清空循环队列
    public void clear() {
        Arrays.fill(data, null);
        size = 0;
        front = 0;
        rear = 0;
    }
}
