package com.jvm;

/**
 * @Author: Zezhao.Zhu
 * @Description: 栈深度测试：局部变量表内容越多，栈帧越大，栈深度越小（通过-Xss可以设置栈的大小）
 * @Create: 2018/5/29 11:53
 * @Modified By：
 */
public class StackOverFlow {
    private int count = 0;

    public void testAdd() {
        count++;
        testAdd();
    }

    public void testAdd1(int a, int b, int c) {
        count++;
        testAdd1(a, b, c);
    }

    public void testAdd2(int a, int b, int c) {
        int d = 0;
        long h = 9l;
        count++;
        testAdd2(a, b, c);
    }

    public void test() {
        try {
            testAdd();
        } catch (Throwable e) {
            System.out.println(e);
            System.out.println("栈深度:" + count);
        }
    }

    public static void main(String[] args) {
        new StackOverFlow().test();
    }
}
