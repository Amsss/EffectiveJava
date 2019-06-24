package com.asynccallback;

/**
 * @description: 测试类
 * @author: zhuzz
 * @date: 2018/12/24 19:44
 */
public class Test {
    public static void main(String[] args) {
        Li li = new Li();
        Wang wang = new Wang(li);
        wang.askQuestion("1 + 1 = ?");
    }
}
