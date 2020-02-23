package com.java8.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-02-28 15:22
 */
public class Dish {
    private final String name;
    private final boolean vegetarian; // 是否是素食
    private final int calories; // 卡路里
    private final Type type;  // 盘子装的菜的类型

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        MEAT, FISH, OTHER;
    }

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        List<String> dishes = menu.stream()
                // 从流中过滤元素
                .filter(dish -> dish.getCalories() > 300)
                // 提取元素
                //.map(Dish::getName)
                .map(Dish::getName)
                // 截断流，使其元素不超过给定的数量
                .limit(10)
                // 将流转换为列表
                .collect(toList());
        int calories = menu.stream()
                .filter(a -> a.calories > 700)
                .mapToInt(Dish::getCalories)
                .boxed()
                .reduce(0, Integer::sum);
        System.out.println(dishes);
        System.out.println(calories);
    }
}
