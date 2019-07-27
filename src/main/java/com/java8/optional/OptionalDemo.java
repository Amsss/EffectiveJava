package com.java8.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-06 11:07
 */
public class OptionalDemo {
    public static void main(String[] args) {
        // of
        // 调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("Sanaulla");
        // 传入参数为null，抛出NullPointerException.
        // Optional<String> someNull = Optional.of(null);
        // ofNullable
        Optional empty = Optional.ofNullable(null);
        // isPresent
        // 在Optional实例内调用get()返回已存在的值
        // 输出Sanaulla
        name.ifPresent(System.out::println);
        // 执行下面的代码会输出：No value present
        // get
        try {
            // 在空的Optional实例上调用get()，抛出NoSuchElementException
            System.out.println(empty.get());
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
        // ifPresent
        // ifPresent方法接受lambda表达式作为参数。
        // lambda表达式对Optional的值调用consumer进行处理。
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });
        // orElse
        // 如果值不为null，orElse方法返回Optional实例的值。
        // 如果为null，返回传入的消息。
        // 输出：There is no value present!
        System.out.println(empty.orElse("There is no value present!"));
        // 输出：Sanaulla
        System.out.println(name.orElse("There is some value!"));
        // orElseGet
        //orElseGet与orElse方法类似，区别在于orElse传入的是默认值，
        //orElseGet可以接受一个lambda表达式生成默认值。
        //输出：Default Value
        System.out.println(empty.orElseGet(() -> "Default Value"));
        //输出：Sanaulla
        System.out.println(name.orElseGet(() -> "Default Value"));
        // orElseThrow
        try {
            //orElseThrow与orElse方法类似。与返回默认值不同，
            //orElseThrow会抛出lambda表达式或方法生成的异常
            empty.orElseThrow(NullPointerException::new);
        } catch (Throwable ex) {
            //输出: No value present in the Optional instance
            System.out.println(ex.getMessage());
        }
        // map
        Optional<String> upperName = name.map(String::toUpperCase);
        System.out.println(upperName.orElse("No value found"));
        // flatMap
        //flatMap与map（Function）非常类似，区别在于传入方法的lambda表达式的返回类型。
        //map方法中的lambda表达式返回值可以是任意类型，在map函数返回之前会包装为Optional。
        //但flatMap方法中的lambda表达式返回值必须是Optionl实例。
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));//输出SANAULLA
        // filter
        //filter方法检查给定的Option值是否满足某些条件。
        //如果满足则返回同一个Option实例，否则返回空Optional。
        Optional<String> longName = name.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));//输出Sanaulla
        //另一个例子是Optional值不满足filter指定的条件。
        Optional<String> anotherName = Optional.of("Sana");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        //输出：name长度不足6字符
        System.out.println(shortName.orElse("The name is less than 6 characters"));
    }
}
