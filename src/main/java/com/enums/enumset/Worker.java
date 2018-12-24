package com.enums.enumset;

import java.util.Set;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-12-24 11:17
 */
public class Worker {
    /**
     *
     */
    String name;
    /**
     *
     */
    Set<DayEnum> availableDayEnums;

    Worker(String name, Set<DayEnum> availableDayEnums) {
        this.name = name;
        this.availableDayEnums = availableDayEnums;
    }

    public String getName() {
        return name;
    }

    public Set<DayEnum> getAvailableDayEnums() {
        return availableDayEnums;
    }
}
