package com.java8.random;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-06 14:12
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        //DoubleStream doubleStream = random.doubles();
        IntStream intStream = random.ints(0, 100);
        // intStream.limit(10).forEach(System.out::println);
        /*List<Integer> randomBetween0And99 = intStream
                .limit(100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(randomBetween0And99);*/
        DoubleStream gaussianStream = Stream.generate(random::nextGaussian).mapToDouble(e -> e);
        List<Double> randomBetween0And991 = gaussianStream
                .filter(e -> (e >= -1.0 && e < 1.0))
                .limit(100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(randomBetween0And991);
    }
}
