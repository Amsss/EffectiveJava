package com.java8.stream;

import com.java8.coloncolon.Test1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @description: 流的创建方式
 * @author: zhuzz
 * @date: 2019-02-28 16:48
 */
public class Test {

    private static List<Dish> menu;

    public static void main(String[] args) {
        /*streamMethodA();
        streamMethodB();
        streamMethodC();
        streamMethodD();
        streamMethodE();*/
        streamMethodF();
        streamMethodG();
        streamMethodH();
        streamMethodI();
    }

    static {
        menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
    }

    /**
     * 由值创建流
     */
    private static void streamMethodA() {
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).map(String::trim).forEach(System.out::println);
    }

    /**
     * 由数组创建流
     */
    private static void streamMethodB() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }

    /**
     * 由集合创建流
     */
    private static void streamMethodC() {
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(calories);
    }

    /**
     * 由文件生成流
     */
    private static void streamMethodD() {
        /*URI uri = null;
        try {
            uri = this.getClass().getClassLoader()
                    .getResource("logstash/sms-state-info.log").toURI();
            try (Stream<String> lines = Files.lines(Paths.get(uri), Charset.defaultCharset())) {
                lines.map(String::toString)
                        .forEach(log -> {
                            System.out.println("长度 log:" + log.length());
                        });
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 由函数生成流：创建无限流
     */
    private static void streamMethodE() {
        Stream.iterate(0, n -> n + 2)
                .limit(20)
                .forEach(System.out::println);
    }

    /**
     * 由函数生成流：创建无限流
     */
    private static void streamMethodF() {
        Stream.generate(Test1::new)
                .limit(20)
                .forEach(System.out::println);
    }

    /**
     * 由值创建流
     */
    private static void streamMethodG() {

    }

    /**
     * 由值创建流
     */
    private static void streamMethodH() {

    }

    /**
     * 由值创建流
     */
    private static void streamMethodI() {

    }
}
