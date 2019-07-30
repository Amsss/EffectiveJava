package com.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-06-12 16:24
 */
public class MethodHandleTest {
    public static void main(String[] args) throws Throwable {
        // lookup() 指定类中查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        // MethodType.methodType 代表"方法类型" ,包含了方法的返回值（第一个参数）和具体参数（第二及以后参数）
        MethodHandle mh = lookup.findStatic(MethodHandleTest.class, "doubleVal", MethodType.methodType(int.class, int.class));
        List<Integer> dataList = Arrays.asList(1, 2, 3, 4, 5);
        // 方法做为参数
        MethodHandleTest.transform(dataList, mh);
        for (Integer data : dataList) {
            //2,4,6,8,10
            System.out.println(data);
        }
    }

    public static List<Integer> transform(List<Integer> dataList, MethodHandle handle) throws Throwable {
        for (int i = 0; i < dataList.size(); i++) {
            //invoke
            dataList.set(i, (Integer) handle.invoke(dataList.get(i)));
        }
        return dataList;
    }

    public static int doubleVal(int val) {
        return val * 2;
    }
}
