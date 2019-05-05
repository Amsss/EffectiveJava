package com.io;

import java.io.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-05-05 10:02
 */
public class OutFile extends DataOutputStream {
    public OutFile(String filename)
            throws IOException {
        super(
                new BufferedOutputStream(
                        new FileOutputStream(filename)));
    }

    public OutFile(File file)
            throws IOException {
        this(file.getPath());
    }
}
