package com.bulidermodel;

/**
 * @description: 轮胎类
 * @author: zhuzz
 * @date: 2018/12/24 19:46
 */
public class Wheel {
    /**
     * 品牌
     */
    private String brand;
    /**
     * 生产日期
     */
    private String producingDate;

    Wheel(String brand, String producingDate) {
        this.brand = brand;
        this.producingDate = producingDate;
    }

    public static Builder custom() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "brand='" + brand + '\'' +
                ", producingDate='" + producingDate + '\'' +
                '}';
    }

    public static class Builder {
        /**
         * 品牌
         */
        private String brand;
        /**
         * 生产日期
         */
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
