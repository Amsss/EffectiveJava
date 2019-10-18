package com.utils;

import java.lang.reflect.Modifier;

/**
 * @description: 反射工具类
 * @author: zhuzz
 * @date: 2019-03-11 14:59
 */
public class ReflectUtil {

    private static final transient int TEMP = 1;

    public static void main(String[] args) throws Exception {
        //154。private static final transient
        testModifier(ReflectUtil.class.getDeclaredField("TEMP").getModifiers());
        //9。public static
        testModifier(ReflectUtil.class.getMethod("main", String[].class).getModifiers());
    }

    private static void testModifier(int mod) {
        System.out.println("----------------------【mod=" + mod + "】----------------------");
        System.out.println("【toString】" + Modifier.toString(mod));
        System.out.println("【isPublic】" + Modifier.isPublic(mod));
        System.out.println("【isPrivate】" + Modifier.isPrivate(mod));
        System.out.println("【isProtected】" + Modifier.isProtected(mod));
        System.out.println("【isStatic】" + Modifier.isStatic(mod));
        System.out.println("【isFinal】" + Modifier.isFinal(mod));
        System.out.println("【isSynchronized】" + Modifier.isSynchronized(mod));
        System.out.println("【isVolatile】" + Modifier.isVolatile(mod));
        System.out.println("【isTransient】" + Modifier.isTransient(mod));
        System.out.println("【isNative】" + Modifier.isNative(mod));
        System.out.println("【isInterface】" + Modifier.isInterface(mod));
        System.out.println("【isAbstract】" + Modifier.isAbstract(mod));
        System.out.println("【isStrict】" + Modifier.isStrict(mod));
    }
}
