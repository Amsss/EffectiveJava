package com.script;

import java.io.IOException;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-08-01 9:19
 */
public class Demo {
    public static void main(String[] args) {
        try {
            //Runtime.getRuntime().exec("notepad.exe");
            Runtime.getRuntime().exec(new String[]{"cmd", "/c"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
