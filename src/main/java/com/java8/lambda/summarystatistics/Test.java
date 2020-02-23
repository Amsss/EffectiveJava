package com.java8.lambda.summarystatistics;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-05 23:22
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> primes = Arrays.asList(2, 3, null, 5, 6, 77, 88, 776, 33, 4, 22, 333, 22);
        IntSummaryStatistics stats = primes.stream().filter(Objects::nonNull).mapToInt(value -> value).summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(stats.getSum());
        System.out.println(stats.getAverage());
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .parallel()
                .max()
                .ifPresent(System.out::println);
        int[] a = new int[]{1, 22222222, 2, 2, 1};
        Arrays.parallelSort(a);
        System.out.println(a);
    }
}
