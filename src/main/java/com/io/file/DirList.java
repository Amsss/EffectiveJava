package com.io.file;

import java.io.File;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-30 16:26
 */
public class DirList {
    public static void main(String[] args) {
        try {
            File path = new File(".");
            String[] list;
            if(args.length == 0) {
                list = path.list(new DirFilter("src"));
            } else {
                list = path.list(new DirFilter(args[0]));
            }
            for(int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
