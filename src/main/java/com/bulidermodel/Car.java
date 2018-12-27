package com.bulidermodel;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018/12/24 11:38
 */
public class Car {
    /**
     * 制造商
     */
    private final String manufacturer;
    private final String brand; // 品牌
    private final String model; // 型号
    private final String producingArea; // 产地
    private final String producingDate; // 生产时间
    private final Engine engine; // 发动机
    private final Wheel wheel; //
    private final Light light; // 车灯

    Car(String manufacturer, String brand, String model, String producingArea,
        String producingDate, Engine engine, Wheel wheel, Light light) {
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.model = model;
        this.producingArea = producingArea;
        this.producingDate = producingDate;
        this.engine = engine;
        this.wheel = wheel;
        this.light = light;
    }

    public static class Builder {
        private String manufacturer; // 制造商
        private String brand; // 品牌
        private String model; // 型号
        private String producingArea; // 产地
        private String producingDate; // 生产时间
        private Engine engine;
        private Wheel wheel;
        private Light light;

        public Builder(String manufacturer, String brand, String model) {
            this.manufacturer = manufacturer;
            this.brand = brand;
            this.model = model;
        }

        public Builder producingArea(String producingArea) {
            this.producingArea = producingArea;
            return this;
        }

        public Builder producingDate(String producingDate) {
            this.producingDate = producingDate;
            return this;
        }

        public Builder engine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder wheel(Wheel wheel) {
            this.wheel = wheel;
            return this;
        }

        public Builder light(Light light) {
            this.light = light;
            return this;
        }

        public Car build() {

            return new Car(manufacturer, brand, model, producingArea,
                    producingDate, engine, wheel, light);
        }
    }

    public static void main(String[] args) {

        Car car = new Builder("Audi", "奥迪", "Q5")
                .producingArea("中国大陆")
                .producingDate("2016-07-01 00:00:00")
                .engine(Engine.custom()
                        .pl("2L")
                        .maxOutputPower("110kW")
                        .rpm(5400)
                        .build())
                .wheel(Wheel.custom()
                        .brand("AA")
                        .producingDate("2016-03-01 00:00:00")
                        .build())
                .light(Light.custom()
                        .brand("5A")
                        .structure("隔热玻璃")
                        .producingDate("2016-02-01 00:00:00")
                        .build())
                .build();

        System.out.println(car);
    }
}
