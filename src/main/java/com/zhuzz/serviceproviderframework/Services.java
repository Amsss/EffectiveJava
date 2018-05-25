package com.zhuzz.serviceproviderframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Services {

    private Services() {
    }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();//存储服务提供者信息
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    // 提供者注册API
    public static void registerDefaultProvider(Provider p) {//默认注册服务提供者
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {//注册服务提供者
        providers.put(name, p);
    }

    // 服务访问API（使用静态工厂方法，返回值为接口类型）
    public static Service newInstance() {//默认实例化服务
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {//实例化服务
        Provider p = providers.get(name);
        if (p == null) {//若不存在注册的服务提供者，则无法提供服务
            throw new IllegalArgumentException("No provider registered with name:" + name);
        }
        return p.newService();//若存在注册的服务提供者，则可newService()提供服务
    }
}
