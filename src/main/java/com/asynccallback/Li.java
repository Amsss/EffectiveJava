package com.asynccallback;

import java.util.concurrent.TimeUnit;

/**
 * @description: 小李
 * @author: zhuzz
 * @date: 2018/12/24 19:43
 */
public class Li {

    private final static int COUNT = 10000;

    /**
     * 相当于B类有参数为CallBack callBack的f()---->背景三
     *
     * @param callBack
     * @param question
     */
    public void executeMessage(CallBack callBack, String question) {
        System.out.println("小王问的问题--->" + question);
        //模拟小李办自己的事情需要很长时间  
        for (int i = 0; i < COUNT; i++) {

        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 小李办完自己的事情之后想到了答案是2 
         */
        String result = "答案是2";
        /**
         * 于是就打电话告诉小王，调用小王中的方法 
         * 这就相当于B类反过来调用A的方法D 
         */
        callBack.solve(result);
    }
}
