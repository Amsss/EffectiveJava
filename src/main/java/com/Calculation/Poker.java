package com.Calculation;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Description: 扑克洗牌
 * @author: zhuzz
 * @date: 2018-09-12 12:25
 */
public class Poker {

    public static String poker(int num) {
        String str = "";
        String[] huase = {"红桃","黑桃","梅花","方块"};
        String[] number = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        if(num/4 > 12) {
            if(num%4 == 0) {
                str += "小鬼";
            } else if(num%4 == 1) {
                str += "大鬼";
            }
        } else {
            str += huase[num%4] + number[num/4] ;
        }
        return str;
    }

    public static void main(String[] args) {
        // 定义变量
        ArrayList list = new ArrayList();
        Random random = new Random();
        Poker poker = new Poker();
        int i = 0;

        // 向数组中增加数字
        for(i=0;i<54;i++) {
            list.add(poker(i));
        }

        // 随机输出数组中的每个数字
        int length = list.size();
        for(i=0;i<length;i++) {
            //随机生成数组下标
            int num = random.nextInt(list.size());
            //取出数字
            System.out.println(list.get(num));
            //将数字从数组中移除
            list.remove(num);
        }
    }
}
