package com.rrti;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-05-06 10:17
 */
public class SweetShop {

    public static void main(String[] args) {
        System.out.println("inside main");
        //new Candy();
        System.out.println("After creating Candy");
        try {
            Class<Gum> gum = (Class<Gum>) Class.forName("com.rrti.Gum");
            System.out.println(gum.newInstance().x);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println( "After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
