package com.io;

import java.io.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-05-05 10:02
 */
public class PrintFile extends PrintStream {
    public PrintFile(String filename)
            throws IOException {
        super(
                new BufferedOutputStream(
                        new FileOutputStream(filename)));
    }

    public PrintFile(File file)
            throws IOException {
        this(file.getPath());
    }
}
