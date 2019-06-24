package com.enums.enumset;

import java.util.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-12-24 11:31
 */
public class Test {
    public static void main(String[] args) {
        Worker[] workers = new Worker[]{
                new Worker("张三", EnumSet.of(
                        DayEnum.MONDAY, DayEnum.TUESDAY, DayEnum.WEDNESDAY, DayEnum.FRIDAY)),
                new Worker("李四", EnumSet.of(
                        DayEnum.TUESDAY, DayEnum.THURSDAY, DayEnum.SATURDAY)),
                new Worker("王五", EnumSet.of(
                        DayEnum.TUESDAY, DayEnum.THURSDAY)),
        };
        // 哪些天一个人都不会来？
        Set<DayEnum> dayEnums = EnumSet.allOf(DayEnum.class);
        for (Worker w : workers) {
            dayEnums.removeAll(w.getAvailableDayEnums());
        }
        System.out.println(dayEnums);
        //有哪些天至少会有一个人来？就是求worker时间的并集
        Set<DayEnum> days1 = EnumSet.noneOf(DayEnum.class);
        for (Worker w : workers) {
            days1.addAll(w.getAvailableDayEnums());
        }
        System.out.println(days1);
        //有哪些天所有人都会来？就是求worker时间的交集
        Set<DayEnum> days2 = EnumSet.allOf(DayEnum.class);
        for (Worker w : workers) {
            days2.retainAll(w.getAvailableDayEnums());
        }
        System.out.println(days2);
        //哪些人周一和周二都会来？
        Set<Worker> availableWorkers = new HashSet<>(16);
        for (Worker w : workers) {
            if (w.getAvailableDayEnums().containsAll(
                    EnumSet.of(DayEnum.MONDAY, DayEnum.TUESDAY))) {
                availableWorkers.add(w);
            }
        }
        for (Worker w : availableWorkers) {
            System.out.println(w.getName());
        }
        //哪些天至少会有两个人来？我们先使用EnumMap统计每天的人数，然后找出至少有两个人的天
        Map<DayEnum, Integer> countMap = new EnumMap<>(DayEnum.class);
        for (Worker w : workers) {
            for (DayEnum d : w.getAvailableDayEnums()) {
                Integer count = countMap.get(d);
                countMap.put(d, count == null ? 1 : count + 1);
            }
        }
        Set<DayEnum> days3 = EnumSet.noneOf(DayEnum.class);
        for (Map.Entry<DayEnum, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= 2) {
                days3.add(entry.getKey());
            }
        }
        System.out.println(days3);
    }
}
