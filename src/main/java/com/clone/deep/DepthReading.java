package com.clone.deep;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-11 15:36
 */
public class DepthReading implements Cloneable {
    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    private double depth;
    public DepthReading(double depth) {
        this.depth = depth;
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
        return "DepthReading{" +
                "depth=" + depth +
                '}';
    }
}
