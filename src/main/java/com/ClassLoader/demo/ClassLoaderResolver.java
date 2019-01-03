package com.ClassLoader.demo;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:00
 */
public abstract class ClassLoaderResolver {
    /**
     * 类装载时初始化（见下面的静态语句块）
     */
    private static IClassLoadStrategy s_strategy;
    /**
     * 如果这个类重新设计时可能需要改变这个值
     */
    private static final int CALL_CONTEXT_OFFSET = 3;
    /**
     * 类装载时初始化（见下面的静态语句块）
     */
    private static final CallerResolver CALLER_RESOLVER;

    static {
        try {
            // 如果当前安全管理器没有("createSecurityManager")运行时权限则可能会失败:
            CALLER_RESOLVER = new CallerResolver();
        } catch (SecurityException se) {
            throw new RuntimeException(
                    "ClassLoaderResolver: could not create CallerResolver: " + se);
        }
        s_strategy = new DefaultClassLoadStrategy();
    }

    /**
     * 这个方法提供给调用此方法的人选择用于类/资源加载的最佳类加载器的实例。
     * 通常涉及JVM中调用者当前类加载器、线程上下文类加载器、系统类加载器和其他类
     * 加载器之间的选择。该加载器实例由setStrategy方法设置的IClassLoadStrategy的 实例提供。
     *
     * @返回类加载器实例给调用者 [返回null表示JVM的启动类加载器]
     */
    public static synchronized ClassLoader getClassLoader() {
        final Class caller = getCallerClass(0);
        final ClassLoadContext ctx = new ClassLoadContext(caller);
        return s_strategy.getClassLoader(ctx);
    }

    public static synchronized IClassLoadStrategy getStrategy() {
        return s_strategy;
    }

    public static synchronized IClassLoadStrategy setStrategy(
            final IClassLoadStrategy strategy) {
        final IClassLoadStrategy old = s_strategy;
        s_strategy = strategy;
        return old;
    }

    /**
     * 一个获取调用者上下文的帮助类。getClassContext()方法对
     * SecurityManager子类可见。只需要创建一个CallerResolver类的实例 不必安装一个实际的安全管理器
     */
    private static final class CallerResolver extends SecurityManager {
        @Override
        protected Class[] getClassContext() {
            return super.getClassContext();
        }

    } // 嵌套类结束

    /*
     * 获取指定偏移量位置的当前方法调用者上下文
     */
    private static Class getCallerClass(final int callerOffset) {
        return CALLER_RESOLVER.getClassContext()[CALL_CONTEXT_OFFSET
                + callerOffset];
    }


}
