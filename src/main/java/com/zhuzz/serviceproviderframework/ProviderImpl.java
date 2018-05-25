package com.zhuzz.serviceproviderframework;

/**
 * @Author: Zezhao.Zhu
 * @Description: 服务提供者
 * @Date: 11:11 2018/5/25
 */
public class ProviderImpl implements Provider {

    @Override
    public Service newService() {
        // TODO Auto-generated method stub
        return new ServiceImpl();
    }

}
