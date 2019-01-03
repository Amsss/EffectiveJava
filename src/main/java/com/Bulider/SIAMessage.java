package com.Bulider;

/**
 * @description: 2222
 * @author: zhuzz
 * @date: 2019/1/3 15:34
 */
public class SIAMessage {
    private final String businessCode;
    private final String type;
    private final String message;
    private final int timeout;

    SIAMessage(String businessCode, String type, String message, int timeout) {
        this.businessCode = businessCode;
        this.type = type;
        this.message = message;
        this.timeout = timeout;
    }

    public static Builder custom(){

        return new Builder();
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public int getTimeout() {
        return timeout;
    }

    public static class Builder {
        private String businessCode;
        private String type;
        private String message;
        private int timeout;

        public Builder setBusinessCode(String businessCode) {
            this.businessCode = businessCode;
            return this;
        }
        public Builder setType(String type) {
            this.type = type;
            return this;
        }
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }
        public Builder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public SIAMessage build() {

            initDefaultValue(this);

            return new SIAMessage(businessCode, message, type, timeout);
        }

        private void initDefaultValue(Builder builder) {

            if(builder.businessCode==null || builder.businessCode.length()<1){
                throw new IllegalArgumentException("businessCode  can not be empty!");
            }

            if(builder.message==null || builder.message.length()<1){
                throw new IllegalArgumentException("message can not be empty!");
            }
            //设置默认mime-type
            if(builder.type==null || builder.type.length()<1){
                builder.type = "application/json";
            }

            if(builder.timeout<1){
                builder.timeout = 6*1000;
            }
        }
    }

    @Override
    public String toString() {
        return "SIAMessage{" +
                "businessCode='" + businessCode + '\'' +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", timeout=" + timeout +
                '}';
    }

	public static void main(String[] args) {
		SIAMessage message = new Builder().setBusinessCode("yrd")
				.setMessage("hello world").setTimeout(1000).build();

		System.out.println(message);

		// 2.
		message = SIAMessage.custom().setBusinessCode("yrd")
				.setMessage("hello world").setTimeout(1000).build();

		System.out.println(message);
	}

}
