package com.java8.stream;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-02-26 17:23
 */
public class Main {
    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();
    private static List<Integer> list3 = new ArrayList<>();
    private static Lock lock = new ReentrantLock();
    private List<Integer> nums = new ArrayList<>();
    private Set<Double> result = new HashSet<>();

    public void run() {
        // 填充原始数据，nums中填充0-9 10个数
        IntStream.range(0, 10).forEach(nums::add);
        //实现Collector接口
        result = nums.stream().parallel().collect(new Collector<Integer, Container, Set<Double>>() {

            @Override
            public Supplier<Container> supplier() {
                return Container::new;
            }

            @Override
            public BiConsumer<Container, Integer> accumulator() {
                return Container::accumulate;
            }

            @Override
            public BinaryOperator<Container> combiner() {
                return Container::combine;
            }

            @Override
            public Function<Container, Set<Double>> finisher() {
                return Container::getResult;
            }

            @Override
            public Set<Characteristics> characteristics() {
                // 固定写法
                return Collections.emptySet();
            }
        });
    }

    public static void main1(String[] args) {
        //count = studentList.stream().filter((student -> student.getCity().equals("chengdu"))).count();
        IntStream.range(0, 36014).forEach(list1::add);

        IntStream.range(0, 36014).parallel().forEach(list2::add);

        IntStream.range(0, 36014).forEach(i -> {
            try {
                lock.lock();
                list3.add(i);
            }finally {
                lock.unlock();
            }
        });

        System.out.println("串行执行的大小：" + list1.size());
        System.out.println("并行执行的大小：" + list2.size());
        System.out.println("加锁并行执行的大小：" + list3.size());

        Main main = new Main();
        main.run();
        System.out.println("原始数据：");
        main.nums.forEach(i -> System.out.print(i + " "));
        System.out.println("\n\ncollect方法加工后的数据：");
        main.result.forEach(i -> System.out.print(i + " "));
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        b.add("2");
        //String Test = ArrayList::new;
        //a.stream().1
        //System.out.println(b);
    }
}
