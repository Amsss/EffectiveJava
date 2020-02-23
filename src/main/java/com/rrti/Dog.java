package com.rrti;

/**
 * @description: Object A instanceof B ： A对象是不是属于B的派生类
 * Class A isInstance Object B : A类是不是B对象的基类或者接口
 * @author: zhuzz
 * @date: 2019-05-09 21:12
 */
public class Dog implements Pet {

    public void test() {
    }

    public static void main(String[] args) {
        try {
            System.out.println(Dog.class.newInstance() instanceof Pet);
            System.out.println(Pet.class.isInstance(Dog.class.newInstance()));
            System.out.println(Dog.class.getSuperclass());
            Class<?>[] xx = Dog.class.getInterfaces();
            System.out.println(xx[0]);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void aa() {

    }
}
