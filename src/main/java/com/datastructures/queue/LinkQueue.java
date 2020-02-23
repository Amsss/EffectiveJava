package com.datastructures.queue;

/**
 * @description: 队列的链式存储结构实现
 * @author: zhuzz
 * @date: 2018-12-26 17:01
 */
public class LinkQueue<E> {
    // 链栈的节点
    private class Node<E> {
        E e;
        Node<E> next;

        public Node() {
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node front;// 队列头，允许删除
    private Node rear;// 队列尾，允许插入
    private int size; //队列当前长度

    public LinkQueue() {
        front = null;
        rear = null;
    }

    //判空
    public boolean empty() {
        return size == 0;
    }

    //插入
    public boolean add(E e) {
        if (empty()) {    //如果队列为空
            front = new Node(e, null);//只有一个节点，front、rear都指向该节点
            rear = front;
        } else {
            Node<E> newNode = new Node<E>(e, null);
            rear.next = newNode; //让尾节点的next指向新增的节点
            rear = newNode; //以新节点作为新的尾节点
        }
        size++;
        return true;
    }

    //返回队首元素，但不删除
    public Node<E> peek() {
        if (empty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            return front;
        }
    }

    //出队
    public Node<E> poll() {
        if (empty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            //得到队列头元素
            Node<E> value = front;
            //让front引用指向原队列头元素的下一个元素
            front = front.next;
            //释放原队列头元素的next引用
            value.next = null;
            size--;
            return value;
        }
    }

    //队列长度
    public int length() {
        return size;
    }
}
