package com.java8.lambda.summarystatistics;

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-05 23:22
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> primes = Arrays.asList(2, 3,null, 5, 6, 77, 88, 776, 33, 4, 22, 333, 22);
        IntSummaryStatistics stats = primes.stream().filter(Objects::nonNull).mapToInt(value -> value).summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(stats.getSum());
        System.out.println(stats.getAverage());
    }
}
