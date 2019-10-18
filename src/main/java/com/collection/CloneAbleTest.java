package com.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-26 17:53
 */
public class CloneAbleTest implements Cloneable {

    private String ss;

    private List<String> list;

    public CloneAbleTest(String a, List<String> xx) {
        ss = a;
        list = xx;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        String[] XX = new String[]{"6", "2", "3", "5", "1"};
        String[] XX1 = new String[]{"1", "2", "3", "5", "6"};
/*        List<String> xx = Arrays.asList(XX);
        Arrays.binarySearch()*/
        int index1 = Arrays.binarySearch(XX, "6");
        //xx.set(0,"222");
        System.out.println(XX);
        CloneAbleTest a = new CloneAbleTest("11111", Arrays.asList("111", "111111111111111111111111"));
        CloneAbleTest b = new CloneAbleTest("222222", Arrays.asList("222", "222222222222222222222222"));
        CloneAbleTest c = (CloneAbleTest) a.clone();
        System.out.println(c);
        a.setSs("我改");
        List<String> hh = a.getList();
        hh.set(0, "我改");
        //  hh.add("xxxxxxxxxxx");
        System.out.println(a);
        System.out.println(c);
    }

    @Override
    public String toString() {
        return "CloneAbleTest{" +
                "ss='" + ss + '\'' +
                ", list=" + list +
                '}';
    }
}
