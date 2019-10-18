package com.framework.serviceprovider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:24
 */
public class Services {

    private Services() {
    }

    /**
     * 存储服务提供者信息
     */
    private static final Map<String, Provider> PROVIDERS = new ConcurrentHashMap<>(16);
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    /**
     * 提供者注册API
     *
     * @param p
     */
    public static void registerDefaultProvider(Provider p) {
        //默认注册服务提供者
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    /**
     * 注册服务提供者
     *
     * @param name
     * @param p
     */
    public static void registerProvider(String name, Provider p) {
        PROVIDERS.put(name, p);
    }

    /**
     * 服务访问API（使用静态工厂方法，返回值为接口类型）
     *
     * @return
     */
    public static Service newInstance() {
        //默认实例化服务
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    /**
     * 实例化服务
     *
     * @param name
     * @return
     */
    public static Service newInstance(String name) {
        Provider p = PROVIDERS.get(name);
        //若不存在注册的服务提供者，则无法提供服务
        if (p == null) {
            throw new IllegalArgumentException("No provider registered with name:" + name);
        }
        //若存在注册的服务提供者，则可newService()提供服务
        return p.newService();
    }
}
