package com.collection.vector;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-25 17:49
 */
public class CrashJava {
    @Override
    public String toString() {
        return "CrashJava address: " + this + "\n";
    }

    public static void main(String[] args) {

        //Vector v = new Vector();
        /*for(int i = 0; i < 10; i++) {
            v.addElement(new CrashJava());
        }*/
        System.out.println(new CrashJava());
    }
}
