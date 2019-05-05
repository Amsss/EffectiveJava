package com.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-30 16:52
 */
public class DirList2 {
    public static FilenameFilter
    filter(final String afn) {
        // Creation of anonymous inner class:
        return new FilenameFilter() {
            String fn = afn;
            @Override
            public boolean accept(File dir, String n) {
                // Strip path information:
                String f = new File(n).getName();
                return f.indexOf(fn) != -1;
            }
        }; // End of anonymous inner class
    }
    public static void main(String[] args) {
        try {
            File path = new File(".");
            String[] list;
            if(args.length == 0) {
                list = path.list(filter("."));
            } else {
                list = path.list(filter(args[0]));
            }
            for(int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}