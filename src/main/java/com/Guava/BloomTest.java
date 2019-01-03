package com.Guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @description: 布隆过滤器
 * @author: zhuzz
 * @date: 2018-12-29 17:49
 */
public class BloomTest {
    public static void main(String[] args) {
        BloomFilter<String> b = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 100000000, 0.0000001);
        b.put("121");
        b.put("122");
        b.put("123");
        long a = 335477043208322L;

        System.out.println(b.mightContain("12321"));
        BloomFilter<String> b1 = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 2147483647, 0.001);
        b1.put("aba");
        b1.put("abb");
        b1.put("abc");
        b1.putAll(b);
        System.out.println(b1.mightContain("123"));
    }
}
