package com.collection.bitset;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * @description: BitSet使用
 * BitSet类实现了一个按需增长的位向量。位Set的每一个组件都有一个boolean值。
 * 用非负的整数将BitSet的位编入索引。可以对每个编入索引的位进行测试、设置或者清除。
 * 通过逻辑与、逻辑或和逻辑异或操作，可以使用一个 BitSet修改另一个 BitSet的内容。
 * 默认情况下，set 中所有位的初始值都是false。
 * @author: zhuzz
 * @date: 2019-04-25 18:33
 */
public class Alibaba {

    private static final Integer COUNT = 1000;

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            int randomResult = random.nextInt(1000);
            list.add(randomResult);
        }
        System.out.println("产生的随机数有");
        for (Integer aList : list) {
            System.out.println(aList);
        }
        BitSet bitSet = new BitSet(1000);
        for (int i = 0; i < COUNT; i++) {
            bitSet.set(list.get(i));
        }
        System.out.println("0~1000不在上述随机数中有" + bitSet.size());
        for (int i = 0; i < COUNT; i++) {
            if (!bitSet.get(i)) {
                System.out.println(i);
            }
        }
    }
}
