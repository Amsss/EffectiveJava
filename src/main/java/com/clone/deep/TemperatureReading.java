package com.clone.deep;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-11 15:36
 */
public class TemperatureReading implements Cloneable {
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    private long time;
    private double temperature;
    public TemperatureReading(double temperature) {
        time = System.currentTimeMillis();
        this.temperature = temperature;
    }
    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public String toString() {
        return "TemperatureReading{" +
                "time=" + time +
                ", temperature=" + temperature +
                '}';
    }
}
