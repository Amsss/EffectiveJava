package com.classloading.demo1;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-25 11:36
 */
abstract class Glyph {
    /**
     *
     */
    abstract void draw();
    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}
