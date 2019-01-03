package com.guava;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: zhuzz
 * @date: 2018-09-17 17:32
 */
public class GuavaTester {

    /*public static void main(String args[]) {
        GuavaTester guavaTester = new GuavaTester();
        Integer a = null;
        Integer b = new Integer(10);
        System.out.println(guavaTester.sum(a, b));
    }*/

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }
    /*public static void main(String args[]){
     *//*GuavaTester guavaTester = new GuavaTester();

        Integer invalidInput = null;
        Optional<Integer> a =  Optional.of(invalidInput);
        Optional<Integer> b =  Optional.of(new Integer(10));
        System.out.println(guavaTester.sum(a,b));*//*
        Optional<Integer> possible=Optional.of(6);
        Optional<Integer> absentOpt=Optional.absent();
        Optional<Integer> NullableOpt=Optional.fromNullable(null);
        Optional<Integer> NoNullableOpt=Optional.fromNullable(10);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
         if(absentOpt.isPresent()){
            System.out.println("absentOpt isPresent:"+absentOpt.isPresent());
        }
        if(NullableOpt.isPresent()){
            System.out.println("fromNullableOpt isPresent:"+NullableOpt.isPresent());
        }
        if(NoNullableOpt.isPresent()){
            System.out.println("NoNullableOpt isPresent:"+NoNullableOpt.isPresent());
        }
    }*/

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        return a.get() + b.get();
    }

    public static void main(String args[]) {
        GuavaTester guavaTester = new GuavaTester();

        Integer value1 =  null;
        Integer value2 =  new Integer(10);
        //Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1);
        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);

        System.out.println(guavaTester.sum11(a,b));


        Supplier<Integer> ultimateAnswerSupplier = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        };
        Supplier<Integer> ultimateAnswer = Suppliers.memoize(ultimateAnswerSupplier);
        for (int i = 1; i < 10; i++) {
            Integer ccc = ultimateAnswer.get();
            System.out.println(ccc);
        }
        Supplier<Integer> aa = Suppliers.memoizeWithExpiration(ultimateAnswerSupplier, 10, TimeUnit.SECONDS);
        for (int i = 1; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer ccc = aa.get();
            System.out.println(ccc);
        }
    }

    public Integer sum11(Optional<Integer> a, Optional<Integer> b) {
        Supplier<Integer> supplier = () -> new Integer(2);
        Supplier<Map<String, Object>> supplier1 = HashMap::new;

        Map user = supplier1.get();
        user.put("1", "2");
        System.out.println(user.toString());
        System.out.println(supplier1.get().toString());
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        System.out.println(a.or(1));
        //Integer value1 = a.or(new Supplier(1));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value2;
    }


}
