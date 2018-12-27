package com.AsyncCallback;

/**
 * @author zhuzz
 * @description: 回调接口
 * @data: 2017-11-29 上午9:40:42
 */
public interface CallBack {

    /**
     * 这个是小李知道答案时要调用的函数告诉小王，也就是回调函数
     *
     * @param result
     */
    void solve(String result);
}
