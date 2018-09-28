package com.Guava;

import com.google.common.primitives.Longs;

import java.util.List;

/**
 * @Description: Longs是基本类型long的实用工具类
 * @author: zhuzz
 * @date: 2018-09-28 16:00
 */
public class GuavaLongsTest {
    public static void main(String args[]) {
        GuavaLongsTest tester = new GuavaLongsTest();
        tester.testLongs();
    }

    private void testLongs() {
        long[] longArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //convert array of primitives to array of objects
        List<Long> objectArray = Longs.asList(longArray);
        System.out.println(objectArray.toString());

        //convert array of objects to array of primitives
        longArray = Longs.toArray(objectArray);
        System.out.print("[ ");
        for (int i = 0; i < longArray.length; i++) {
            System.out.print(longArray[i] + " ");
        }
        System.out.println("]");
        //check if element is present in the list of primitives or not
        System.out.println("5 is in list? " + Longs.contains(longArray, 5));

        //Returns the minimum
        System.out.println("Min: " + Longs.min(longArray));

        //Returns the maximum
        System.out.println("Max: " + Longs.max(longArray));

        //get the byte array from an integer
        byte[] byteArray = Longs.toByteArray(20000);
        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }
    }
}
