package com.zhuzz.bulidermodel;

public class Wheel {
	 private String brand;
	    private String producingDate;

	    Wheel(String brand, String producingDate) {
	        this.brand = brand;
	        this.producingDate = producingDate;
	    }

	    public static Builder custom(){

	        return new Builder();
	    }

	    public static class Builder{
	        private String brand;
	        private String producingDate;

	        public Builder brand(String brand){
	            this.brand = brand;
	            return this;
	        }

	        public Builder producingDate(String producingDate){
	            this.producingDate = producingDate;
	            return this;
	        }

	        public Wheel build(){

	            return new Wheel(brand, producingDate);
	        }
	    }
}
