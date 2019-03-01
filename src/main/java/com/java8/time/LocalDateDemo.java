package com.java8.time;

import java.time.LocalDate;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-03-01 10:35
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2000, 12, 12);
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfWeek().getValue();
        int maxLength = localDate.getMonth().maxLength();
        int minLength = localDate.getMonth().minLength();
        boolean isLeap = localDate.isLeapYear();
        System.out.println("TimeTest.testLocalDateOf year: " + year + "\tmonth: " + month + "\tday: " + day
                + "\tmaxLength: " + maxLength + "\tminLength: " + minLength + "\tisLeap: " + isLeap);
    }
}
