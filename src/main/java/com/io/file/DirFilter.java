package com.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-30 16:26
 */
public class DirFilter implements FilenameFilter {
    String afn;

    DirFilter(String afn) {
        this.afn = afn;
    }

    @Override
    public boolean accept(File dir, String name) {
        // Strip path information:
        String f = new File(name).getName();
        return !f.contains(afn);
    }
}