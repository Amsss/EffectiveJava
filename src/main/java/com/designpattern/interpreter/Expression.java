package com.designpattern.interpreter;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:36
 */
public interface Expression {
    /**
     *
     * @param context
     * @return
     */
    int interpret(Context context);
}
