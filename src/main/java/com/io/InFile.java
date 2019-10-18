package com.io;

import java.io.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-05-05 10:01
 */
public class InFile extends DataInputStream {
    public InFile(String filename)
            throws FileNotFoundException {
        super(
                new BufferedInputStream(
                        new FileInputStream(filename)));
    }

    public InFile(File file)
            throws FileNotFoundException {
        this(file.getPath());
    }
}
