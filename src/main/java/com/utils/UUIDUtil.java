package com.utils;

import java.util.UUID;

/**
 * @description:
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
}
