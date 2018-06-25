package com.bulidermodel;

public class Light {
	private String brand;
    private String structure;   //结构
    private String producingDate;

    Light(String brand, String structure, String producingDate) {
        this.brand = brand;
        this.structure = structure;
        this.producingDate = producingDate;
    }

    public static Builder custom(){

        return new Builder();
    }

    public static class Builder{
        private String brand;
        private String structure;   //结构
        private String producingDate;

        public Builder brand(String brand){
            this.brand = brand;
            return this;
        }

        public Builder structure(String structure){
            this.structure = structure;
            return this;
        }

        public Builder producingDate(String producingDate){
            this.producingDate = producingDate;
            return this;
        }

        public Light build(){

            return new Light(brand, structure, producingDate);
        }
    }
}
