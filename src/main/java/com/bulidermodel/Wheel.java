package com.bulidermodel;

/**
 * @description: 轮胎
 * @author: zhuzz
 * @date: 2018/12/24 19:46
 */
public class Wheel {
    private String brand;
    private String producingDate;

    Wheel(String brand, String producingDate) {
        this.brand = brand;
        this.producingDate = producingDate;
    }

    public static Builder custom() {

        return new Builder();
    }

    public static class Builder {
        private String brand;
        private String producingDate;

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder producingDate(String producingDate) {
            this.producingDate = producingDate;
            return this;
        }

        public Wheel build() {

            return new Wheel(brand, producingDate);
        }
    }
}
