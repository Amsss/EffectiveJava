package com.utils;

import java.util.UUID;

/**
 * @description: 生成UUID
 * @author: zhuzz
 * @date: 2019-04-03 17:46
 */
public class UUIDUtil {

    private UUIDUtil() {

    }

    /**
     * 获取uuid
     *
     * @return
     */
    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(UUIDUtil.getId());
    }
}
