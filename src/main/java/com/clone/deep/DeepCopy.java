package com.clone.deep;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-11 15:37
 */
public class DeepCopy {
    public static void main(String[] args) {
        OceanReading reading = new OceanReading(33.9, 100.5);
        // Now clone it:
        System.out.println(reading);
        OceanReading r = (OceanReading)reading.clone();
        r.getDepth().setDepth(11);
        r.getTemperature().setTemperature(111);
        System.out.println(reading);
        System.out.println(r);
    }
}
