package com.classloading;

/**
 * @description:
 * (1) 在采取其他任何操作之前，为对象分配的存储空间初始化成二进制零。
 * (2) 就象前面叙述的那样，调用基类构造器。此时，被覆盖的draw()方法会得到调用（的确是在RoundGlyph构造器调用之前），此时会发现radius的值为0，这是由于步骤(1)造成的。
 * (3) 按照原先声明的顺序调用成员初始化代码。
 * (4) 调用派生类构造器的主体。
 *
 * 一条常规的设计准则是：用继承表达行为间的差异，并用成员变量表达状态的变化。
 * @author: zhuzz
 * @date: 2019-04-25 11:37
 */
public class RoundGlyph extends Glyph {

    int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println(
                "RoundGlyph.RoundGlyph(), radius = "
                        + radius);
    }

    @Override
    void draw() {
        System.out.println(
                "RoundGlyph.draw(), radius = " + radius);
    }
}
