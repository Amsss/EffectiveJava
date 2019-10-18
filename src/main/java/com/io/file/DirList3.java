package com.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-30 16:54
 */
public class DirList3 {
    public static void main(final String[] args) {
        try {
            File path = new File(".");
            String[] list;
            if (args.length == 0) {
                list = path.list();
            } else {
                list = path.list(
                        new FilenameFilter() {
                            @Override
                            public boolean
                            accept(File dir, String n) {
                                String f = new File(n).getName();
                                return f.indexOf(args[0]) != -1;
                            }
                        });
            }
            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
