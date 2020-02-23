package com.bulider;

/**
 * @description: 发动机类
 * @author: zhuzz
 * @date: 2019/1/3 15:32
 */
public class Engine {
    /**
     * 排量
     */
    private final String pl;
    /**
     * 最大输出功率
     */
    private final String maxOutputPower;
    /**
     * 转速
     */
    private final int rpm;

    Engine(String pl, String maxOutputPower, int rpm) {
        this.pl = pl;
        this.maxOutputPower = maxOutputPower;
        this.rpm = rpm;
    }

    public static Builder custom() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Engine{" +
                "pl='" + pl + '\'' +
                ", maxOutputPower='" + maxOutputPower + '\'' +
                ", rpm=" + rpm +
                '}';
    }

    public static class Builder {
        /**
         * 排量
         */
        private String pl;
        /**
         * 最大输出功率
         */
        private String maxOutputPower;
        /**
         * 转速
         */
        private int rpm;

        public Builder pl(String pl) {
            this.pl = pl;
            return this;
        }

        public Builder maxOutputPower(String maxOutputPower) {
            this.maxOutputPower = maxOutputPower;
            return this;
        }

        public Builder rpm(int rpm) {
            this.rpm = rpm;
            return this;
        }

        public Engine build() {
            return new Engine(pl, maxOutputPower, rpm);
        }
    }
}
