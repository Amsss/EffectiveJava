package com.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-03-01 10:35
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        System.out.println(LocalTime.now());
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println(Year.now().toString());
        System.out.println(YearMonth.parse("2019-02").plusMonths(-1).toString());
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth.plusMonths(-1));
        LocalDate dateOfBirth = LocalDate.of(2010, 7, 8);
        System.out.println(dateOfBirth.format(DateTimeFormatter.ofPattern("yyyy.MM")));

        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }

        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        Period periodToNextJavaRelease =
                Period.between(dateOfBirth, java8Release);
        System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths());
        periodToNextJavaRelease.getDays();

        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);


        LocalDate now = LocalDate.now().plusDays(-1);
        LocalDate date = LocalDate.parse("2017-12-12");
        int x = date.getMonth().getValue();
        String dateString = date.toString();
        LocalTime time = LocalTime.parse("14:22:28");
        //LocalDateTime，是LocalDate和LocalTime的合体。它同时表示了日期和时间，但不带有时区信息，你可以直接创建，也可以通过合并日期和时间对象构造
        Instant instant = Instant.now();
        System.out.println("TimeTest.testInstant 时间戳 ： " + System.currentTimeMillis());
        System.out.println("TimeTest.testInstant 时间戳 ： " + instant.atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli());
        System.out.println("TimeTest.testInstant 时间戳 ： " + instant.atZone(ZoneId.of("GMT+08:00")).toInstant().toEpochMilli());
        System.out.println("TimeTest.testInstant 时间戳 ： " + instant.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        methodA();
        methodB();
    }

    /**
     *
     */
    private static void methodA() {
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

    /**
     *
     */
    private static void methodB() {
        LocalDate localDate = LocalDate.of(2017, 12, 12);
        int year = localDate.get(ChronoField.YEAR);
        int month = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.get(ChronoField.DAY_OF_MONTH);
        System.out.println("TimeTest.testTemporalField year: " + year + "\tmonth: " + month + "\tday: " + day);
    }

    /**
     *
     */
    private static void methodC() {
        LocalTime time = LocalTime.of(14, 22, 28);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println("TimeTest.testLocalTime hour: " + hour + "\tminute: " + minute + "\tsecond: " + second);
    }

    /**
     *
     */
    private static void methodD() {
        LocalDate date = LocalDate.of(2017, 12, 12);
        LocalTime time = LocalTime.of(14, 22, 28);

        LocalDateTime dt1 = LocalDateTime.of(2017, Month.MARCH, 12, 14, 22, 28);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println("TimeTest.testLocalDateTimeCombine dt1: " + dt1 + "\td2: " + dt2 + "\tdt3: " + dt3 + "\tdt4: " + dt4 + "\tdt5: " + dt5);
        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
    }

    /**
     *
     */
    private static void methodE() {
    }

    /**
     *
     */
    private static void methodF() {
    }

    /**
     *
     */
    private static void methodG() {

    }

    /**
     *
     */
    private static void methodH() {

    }

    /**
     *
     */
    private static void methodI() {

    }

}
