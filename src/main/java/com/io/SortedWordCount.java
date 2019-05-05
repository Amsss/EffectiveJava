package com.io;

import com.compare.StrSortVector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-05-05 10:13
 */
public class SortedWordCount {
    private FileInputStream file;
    private StreamTokenizer st;
    private Hashtable counts = new Hashtable();

    SortedWordCount(String filename)
            throws FileNotFoundException {
        try {
            file = new FileInputStream(filename);
            st = new StreamTokenizer(file);
            st.ordinaryChar('.');
            st.ordinaryChar('-');
        } catch (FileNotFoundException e) {
            System.out.println(
                    "Could not open " + filename);
            throw e;
        }
    }

    void cleanup() {
        try {
            file.close();
        } catch (IOException e) {
            System.out.println(
                    "file.close() unsuccessful");
        }
    }

    void countWords() {
        try {
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                String s;
                //在调用 nextToken 方法之后，ttype字段将包含刚读取的标记的类型
                switch (st.ttype) {
                    //TT_EOF指示已读到流末尾的常量。
                    case StreamTokenizer.TT_EOL:
                        s = new String("EOL");
                        break;
                    //TT_NUMBER指示已读到一个数字标记的常量
                    case StreamTokenizer.TT_NUMBER:
                        //如果当前标记是一个数字，nval字段将包含该数字的值
                        s = Double.toString(st.nval);
                        break;
                    //TT_WORD指示已读到一个文字标记的常量
                    case StreamTokenizer.TT_WORD:
                        //如果当前标记是一个文字标记，sval字段包含一个给出该文字标记的字符的字符串
                        s = st.sval;
                        break;
                    //如果以上3中类型都不是，则为英文的标点符号
                    default:
                        s = String.valueOf((char) st.ttype);
                }
                if (counts.containsKey(s)) {
                    ((Counter) counts.get(s)).increment();
                } else {
                    counts.put(s, new Counter());
                }
            }
        } catch (IOException e) {
            System.out.println(
                    "st.nextToken() unsuccessful");
        }
    }

    Enumeration values() {
        return counts.elements();
    }

    Enumeration keys() {
        return counts.keys();
    }

    Counter getCounter(String s) {
        return (Counter) counts.get(s);
    }

    Enumeration sortedKeys() {
        Enumeration e = counts.keys();
        StrSortVector sv = new StrSortVector();
        while (e.hasMoreElements()) {
            sv.addElement((String) e.nextElement());
        }
        // This call forces a sort:
        return sv.elements();
    }

    public static void main(String[] args) {
        try {
            SortedWordCount wc =
                    new SortedWordCount("D:\\hello.txt");
            wc.countWords();
            Enumeration keys = wc.sortedKeys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                System.out.println(key + ": "
                        + wc.getCounter(key).read());
            }
            wc.cleanup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
