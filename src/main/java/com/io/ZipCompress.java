package com.io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-05-05 13:45
 */
public class ZipCompress {

    public static void main(String[] args) {
        String[] fileArray = new String[]{"B.txt", "C.txt", "D.txt"};
        try {
            FileOutputStream f = new FileOutputStream("serialization.zip");
            CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(csum));
            out.setComment("A serialization of Java Zipping");
            // Can't read the above comment, though
            for (int i = 0; i < fileArray.length; i++) {
                System.out.println("Writing file " + fileArray[i]);
                BufferedReader in = new BufferedReader(new FileReader(fileArray[i]));
                out.putNextEntry(new ZipEntry(fileArray[i]));
                int c;
                while ((c = in.read()) !=
                        -1) {
                    out.write(c);
                }
                in.close();
            }
            out.close();
            // Checksum valid only after the file
            // has been closed!
            System.out.println("Checksum: " + csum.getChecksum().getValue());
            // Now extract the files:
            System.out.println("Reading file");
            FileInputStream fi = new FileInputStream("serialization.zip");
            CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
            ZipInputStream in2 = new ZipInputStream(new BufferedInputStream(csumi));
            ZipEntry ze;
            System.out.println("Checksum: " + csumi.getChecksum().getValue());
            while ((ze = in2.getNextEntry()) != null) {
                System.out.println("Reading file " + ze);
                int x;
                while ((x = in2.read()) !=
                        -1) {
                    System.out.write(x);
                }
            }
            in2.close();
            // Alternative way to open and read
            // zip files:
            ZipFile zf = new ZipFile("serialization.zip");
            Enumeration e = zf.entries();
            while (e.hasMoreElements()) {
                ZipEntry ze2 = (ZipEntry) e.nextElement();
                System.out.println("File: " + ze2);
                // ... and extract the data as before
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
