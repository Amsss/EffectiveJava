package com.createanddestruction;

/**
 * @author zhuzz
 * @类功能说明:
 * @创建时间:2017-10-25 下午4:19:09
 */
public class StaticFactoryMethod {

    /**
     * 基本类型转换成Boolean对象引用
     * @param a
     * @return
     * @方法说明：
     */
    public static Boolean valueOf(boolean a) {
        return a ? Boolean.TRUE : Boolean.FALSE;
    }


    public static void main(String[] args) {

        //静态工厂方法--------------经常创建相同的对象 例子
        //BigInteger i = BigInteger.probablePrime(3, new Random(100));
        //System.out.println(i);
        //Boolean.valueOf(true);
        //List<String> a = new ArrayList<String>();
        //EnumSet a = EnumSet;

    }
}
