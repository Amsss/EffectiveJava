package com.internal;


/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-23 10:27
 */
public class Parcel4 {

    public Destination dest(String s) {
        /*new Destination(){
            @Override
            public String readLabel() {
                return s;
            }
        };*/
        class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }
/*    public static String base64Encoded1(byte[] param) {
        return Base64Util.getEncoder().encodeToString(param);
    }

    public static String base64Encoded(byte[] param) {

        return net.iharder.Base64Util.encodeBytes(param);
    }*/
    public static void main(String[] args) {
/*        String A = "22222222";
        System.out.println(base64Encoded(A.getBytes()));
        System.out.println(base64Encoded1(A.getBytes()));*/
        Parcel4 p = new Parcel4();
        Destination d = p.dest("Tanzania");
    }
}
