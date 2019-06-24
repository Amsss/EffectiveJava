package com.io;

import java.io.*;

/**
 * @description: java1.0的io
 * @author: zhuzz
 * @date: 2019-04-30 17:10
 */
public class IoStreamDemo {
    public static void main(String[] args) {
        try {
            // 1. Buffered input file
            String s;
            String s2;
            StringBufferInputStream in2;
            int c;
            RandomAccessFile rf;
            InFile in6;
            PrintFile out3;
            OutFile out4;
            try (DataInputStream in = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("D:\\hello.txt")))) {
                s2 = new String();
                while ((s = in.readLine()) != null) {
                    s2 += s + "\n";
                }
                in.close();
            }
            // 2. Input from memory
            in2 = new StringBufferInputStream(s2);
            while ((c = in2.read()) != -1) {
                System.out.print((char) c);
            }
            // 3. Formatted memory input
            try {
                DataInputStream in3 =
                        new DataInputStream(
                                new StringBufferInputStream(s2));
                while (true) {
                    System.out.print((char) in3.readByte());
                }
            } catch (EOFException e) {
                System.out.println(
                        "End of stream encountered");
            }
            // 4. Line numbering & file output
            try {
                LineNumberInputStream li =
                        new LineNumberInputStream(
                                new StringBufferInputStream(s2));
                DataInputStream in4 =
                        new DataInputStream(li);
                PrintStream out1 =
                        new PrintStream(
                                new BufferedOutputStream(
                                        new FileOutputStream(
                                                "IODemo.out")));
                while ((s = in4.readLine()) != null) {
                    out1.println(
                            "Line " + li.getLineNumber() + s);
                }
                out1.close(); // finalize() not reliable!
            } catch (EOFException e) {
                System.out.println(
                        "End of stream encountered");
            }
            // 5. Storing & recovering data
            try {
                DataOutputStream out2 =
                        new DataOutputStream(
                                new BufferedOutputStream(
                                        new FileOutputStream("Data.txt")));
                out2.writeBytes(
                        "Here's the value of pi: \n");
                out2.writeDouble(3.14159);
                out2.close();
                DataInputStream in5 =
                        new DataInputStream(
                                new BufferedInputStream(
                                        new FileInputStream("Data.txt")));
                System.out.println(in5.readLine());
                System.out.println(in5.readDouble());
            } catch (EOFException e) {
                System.out.println(
                        "End of stream encountered");
            }
            // 6. Reading/writing random access files
            rf = new RandomAccessFile("rtest.dat", "rw");
            for (int i = 0; i < 10; i++) {
                rf.writeDouble(i * 1.414);
            }
            rf.close();
            rf = new RandomAccessFile("rtest.dat", "rw");
            rf.seek(5 * 8);
            rf.writeDouble(47.0001);
            rf.close();
            rf = new RandomAccessFile("rtest.dat", "r");
            for (int i = 0; i < 10; i++) {
                System.out.println("Value " + i + ": " + rf.readDouble());
            }
            rf.close();
            // 7. File input shorthand
            in6 = new InFile(args[0]);
            String s3 = new String();
            System.out.println(
                    "First line in file: " +
                            in6.readLine());
            in6.close();
            // 8. Formatted file output shorthand
            out3 = new PrintFile("Data2.txt");
            out3.print("Test of PrintFile");
            out3.close();
            // 9. Data file output shorthand
            out4 = new OutFile("Data3.txt");
            out4.writeBytes("Test of outDataFile\n\r");
            out4.writeChars("Test of outDataFile\n\r");
            out4.close();
        } catch (FileNotFoundException e) {
            System.out.println(
                    "File Not Found:" + args[0]);
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }
}
