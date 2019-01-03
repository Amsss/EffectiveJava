package com.serviceproviderframework;

/**
 * @description: 服务提供者
 * @author: zhuzz
 * @date: 2019/1/3 16:23
 */
public class ProviderImpl implements Provider {

    @Override
    public Service newService() {
        return new ServiceImpl();
    }
}
