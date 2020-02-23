package com.rrti;

/**
 * @description: RTTI（Run-Time Type Identification）运行时类型识别，对于这个词一直是 C++ 中的概念，
 * 至于Java中出现RRTI的说法则是源于《Thinking in Java》一书，其作用是在运行时识别一个对象的类型和类的信息，
 * 这里分两种：传统的”RRTI”,它假定我们在编译期已知道了所有类型(在没有反射机制创建和使用类对象时，一般都是编译期已确定其类型，
 * 如new对象时该类必须已定义好)，另外一种是反射机制，它允许我们在运行时发现和使用类型的信息。在Java中用来表示运行时类型信息的对应类就是Class类，
 * Class类也是一个实实在在的类
 * @author: zhuzz
 * @date: 2019-05-06 10:17
 */
public class SweetShop {

    public static void main(String[] args) {
        System.out.println("inside main");
        //new Candy();
        System.out.println("After creating Candy");
        try {
            Class<Gum> gum = (Class<Gum>) Class.forName("com.rrti.Gum");
            System.out.println(gum.newInstance().x);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
