package com.clone.deep;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-11 15:37
 */
public class OceanReading implements Cloneable {
    private DepthReading depth;

    public DepthReading getDepth() {
        return depth;
    }

    public void setDepth(DepthReading depth) {
        this.depth = depth;
    }

    public TemperatureReading getTemperature() {
        return temperature;
    }

    public void setTemperature(TemperatureReading temperature) {
        this.temperature = temperature;
    }

    private TemperatureReading temperature;

    public OceanReading(double tdata, double ddata) {
        temperature = new TemperatureReading(tdata);
        depth = new DepthReading(ddata);
    }

    @Override
    public Object clone() {
        OceanReading o = null;
        try {
            o = (OceanReading) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // Must clone handles:
        o.depth = (DepthReading) o.depth.clone();
        o.temperature = (TemperatureReading) o.temperature.clone();
        return o; // Upcasts back to Object
    }

    @Override
    public String toString() {
        return "OceanReading{" +
                "depth=" + depth +
                ", temperature=" + temperature +
                '}';
    }
}
