package com.classLoading.passiveReference;

/**
 * @Description: 被动使用类字段演示二：通过数组定义来引用类，不会触发此类初始化
 * (注：此处代码触发了另一个名为"[com.classLoading.passiveReference.SuperClass"的类的初始化，
 * 是由虚拟机自动生成的、直接继承java.lang.Objcet的子类，创建动作由字节码指令newarray触发)
 * @author: zhuzz
 * @date: 2018-06-12 15:31
 */
public class Test2 {
    public static void main(String[] args) {
        SuperClass [] superClasses = new SuperClass[10];
    }
}
