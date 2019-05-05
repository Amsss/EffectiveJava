package com.exception;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-30 15:08
 */
public class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception!";
    }
}
