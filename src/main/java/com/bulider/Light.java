package com.bulider;

/**
 * @description: 车灯类
 * @author: zhuzz
 * @date: 2019/1/3 15:32
 */
public class Light {
    /**
     * 品牌
     */
    private String brand;
    /**
     * 结构
     */
    private String structure;
    /**
     * 生产日期
     */
    private String producingDate;

    Light(String brand, String structure, String producingDate) {
        this.brand = brand;
        this.structure = structure;
        this.producingDate = producingDate;
    }

    public static Builder custom() {

        return new Builder();
    }

    @Override
    public String toString() {
        return "Light{" +
                "brand='" + brand + '\'' +
                ", structure='" + structure + '\'' +
                ", producingDate='" + producingDate + '\'' +
                '}';
    }

    public static class Builder {
        /**
         * 品牌
         */
        private String brand;
        /**
         * 结构
         */
        private String structure;
        /**
         * 生产日期
         */
        private String producingDate;

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder structure(String structure) {
            this.structure = structure;
            return this;
        }

        public Builder producingDate(String producingDate) {
            this.producingDate = producingDate;
            return this;
        }

        public Light build() {
            return new Light(brand, structure, producingDate);
        }
    }
}
