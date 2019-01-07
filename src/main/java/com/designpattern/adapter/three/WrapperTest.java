package com.designpattern.adapter.three;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:19
 */
public class WrapperTest {
    public static void main(String[] args) {
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();
        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }
}
