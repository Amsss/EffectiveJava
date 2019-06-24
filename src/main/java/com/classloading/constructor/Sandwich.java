package com.classloading.constructor;

/**
 * @description: 构造函数加载顺序
 * (1) 调用基类构造器。这个步骤会不断重复下去，首先得到构建的是分级结构的根部，然后是下一个派生类，等等。直到抵达最深一层的派生类。
 * (2) 按声明顺序调用成员初始化模块。
 * (3) 调用派生构造器的主体。
 * @author: zhuzz
 * @date: 2019-04-25 10:45
 */
class Sandwich extends PortableLunch {
    Bread bread = new Bread();
    Cheese cheese = new Cheese();
    Lettuce lettuce = new Lettuce();

    private Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}
