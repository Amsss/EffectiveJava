package com.jvm.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;

/**
 * @description: Bootstrap ClassLoader、Extension ClassLoader、App ClassLoader三者的关系如下：
 * Bootstrap ClassLoader由JVM启动，然后初始化sun.misc.Launcher，sun.misc.Launcher初始化Extension ClassLoader 、App ClassLoader。
 * Bootstrap ClassLoader是Extension ClassLoader的parent，Extension ClassLoader是App ClassLoader的parent。
 * 但是这并不是继承关系，只是语义上的定义，基本上，每一个ClassLoader实现，都有一个Parent ClassLoader。
 * 可以通过ClassLoader的getParent方法得到当前ClassLoader的parent。Bootstrap ClassLoader比较特殊，
 * 因为它不是java class所以Extension ClassLoader的getParent方法返回的是NULL
 * @author: zhuzz
 * @date: 2019-07-22 16:31
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        testA();
        testB();
        try {
            testC();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 我们无法获得引导类加载器，因为它是使用c实现的，而且使用引导类加载器加载的类通过getClassLoader 方法返回的是null.
     * 所以无法直接操作引导类加载器，但是我们可以根据Class.getClassLoader 方法是否为null 判断这个类是不是引导类加载器加载的;
     * 但是我们可以通过下面的方法获得经由“引导类加载器”加载的类的路径(值得注意的是:每个jar包对应了一个URL)
     */
    private static void testA() {
        List<URL> list = Arrays.asList(sun.misc.Launcher.getBootstrapClassPath().getURLs());
        for (URL url : list) {
            System.out.println(url.toString());
        }
    }

    private static void testB() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader---->" + loader);
        System.out.println("parent loader-->" + loader.getParent());
        System.out.println("grandparent loader->" + loader.getParent().getParent());
    }

    private static void testC() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, MalformedURLException {
        URL url = new URL("file:C:/MyProject/EffectiveJava/target/classes/com/jvm/classloader");
        URL[] urls = {url};
        ClassLoader classLoader = new URLClassLoader(urls);
        // 设置该线程的上下文ClassLoader
        Thread.currentThread().setContextClassLoader(classLoader);
        // 使用loadClass方法加载class,这个class是在urls参数指定的classpath下边
        Class clazz = classLoader.loadClass("com.jvm.classloader.ClassWillBeLoaded");
        // 然后我们就可以用反射做些事情了
        Method taskMethod = clazz.getMethod("doTask", String.class, String.class);
        Object returnValue = taskMethod.invoke(clazz.newInstance(), "serialization", "success");
        System.out.println((String) returnValue);
    }
}
