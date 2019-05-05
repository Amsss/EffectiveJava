package com.io.serializable;

import java.io.Serializable;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-05-05 14:17
 */
public class Data implements Serializable {
    private int i;

    Data(int x) {
        i = x;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
