package com.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: java8中metaspace总结如下：
 * PermGen 空间的状况
 * 这部分内存空间将全部移除。
 * JVM的参数：PermSize 和 MaxPermSize 会被忽略并给出警告（如果在启用时设置了这两个参数）。
 * Metaspace 内存分配模型
 * 大部分类元数据都在本地内存中分配。
 * 用于描述类元数据的“klasses”已经被移除。
 * Metaspace 容量
 * 默认情况下，类元数据只受可用的本地内存限制（容量取决于是32位或是64位操作系统的可用虚拟内存大小）。
 * 新参数（MaxMetaspaceSize）用于限制本地内存分配给类元数据的大小。如果没有指定这个参数，元空间会在运行时根据需要动态调整。
 * Metaspace 垃圾回收
 * 对于僵死的类及类加载器的垃圾回收将在元数据使用达到“MaxMetaspaceSize”参数的设定值时进行。
 * 适时地监控和调整元空间对于减小垃圾回收频率和减少延时是很有必要的。持续的元空间垃圾回收说明，可能存在类、类加载器导致的内存泄漏或是大小设置不合适。
 * Java 堆内存的影响
 * 一些杂项数据已经移到Java堆空间中。升级到JDK8之后，会发现Java堆 空间有所增长。
 * @author: zhuzz
 * @date: 2019-07-07 14:45
 */
public class MetaspaceOOM {
    public static void main(String[] args) {
        /*try {
            //准备url
            URL url = new File("D:/com/jvm/").toURI().toURL();
            URL[] urls = {url};
            //获取有关类型加载的JMX接口
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            //用于缓存类加载器
            List<ClassLoader> classLoaders = new ArrayList<>();
            while (true) {
                //加载类型并缓存类加载器实例
                ClassLoader classLoader = new URLClassLoader(urls);
                classLoaders.add(classLoader);
                classLoader.loadClass("com.jvm.ClassA");
                //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
                //System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
                //System.out.println("active: " + loadingBean.getLoadedClassCount());
                //System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        int i = 0;
        while (true) {
            System.out.println(i++);
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Object.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(
                    new MethodInterceptor() {
                        @Override
                        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                            return methodProxy.invokeSuper(o, args);
                        }
                    }
            );
            enhancer.create();
        }
    }
}
