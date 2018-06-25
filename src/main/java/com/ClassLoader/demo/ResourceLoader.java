package com.ClassLoader.demo;

import java.net.URL;

public abstract class ResourceLoader {

    /**
     * @see ClassLoader#loadClass(String)
     */
    public static Class loadClass(final String name)
            throws ClassNotFoundException {
        final ClassLoader loader = ClassLoaderResolver.getClassLoader();
        return Class.forName(name, false, loader);
    }

    /**
     * @see ClassLoader#getResource(String)
     */
    public static URL getResource(final String name) {
        final ClassLoader loader = ClassLoaderResolver.getClassLoader();
        if (loader != null)
            return loader.getResource(name);
        else
            return ClassLoader.getSystemResource(name);
    }
}
