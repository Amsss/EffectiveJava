package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: -Xms20m  堆内存最小值 -Xmx20m 堆内存最大值 -XX:+HeapDumpOnOutOfMemoryError dump文件输出
 * @author: zhuzz
 * @date: 2019/1/7 12:07
 */
public class HeapOOM {
    static class OOMObject {

    }

    /**
     * @Author: Zezhao.Zhu
     * @Description: 谨慎启动！！！！需设置堆内存大小再使用
     * @Date: 20:14 2018/5/29
     */
    public static void main(String[] args) {
        System.out.println("1");
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
