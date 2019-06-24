package com.guava;

import com.google.common.primitives.Bytes;

import java.util.List;

/**
 * @description: Bytes是byte的基本类型实用工具类。
 * @author: zhuzz
 * @date: 2018-09-28 15:57
 */
public class GuavaBytesTest {
    public static void main(String args[]) {
        GuavaBytesTest tester = new GuavaBytesTest();
        tester.testBytes();
    }

    private void testBytes() {
        byte[] byteArray = {1, 2, 3, 4, 5, 5, 7, 9, 9};

        //convert array of primitives to array of objects
        List<Byte> objectArray = Bytes.asList(byteArray);
        System.out.println(objectArray.toString());

        //convert array of objects to array of primitives
        byteArray = Bytes.toArray(objectArray);
        System.out.print("[ ");
        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }
        System.out.println("]");
        byte data = 5;
        //check if element is present in the list of primitives or not
        System.out.println("5 is in list? " + Bytes.contains(byteArray, data));

        //Returns the index
        System.out.println("Index of 5: " + Bytes.indexOf(byteArray, data));

        //Returns the last index maximum
        System.out.println("Last index of 5: " + Bytes.lastIndexOf(byteArray, data));
    }
}
