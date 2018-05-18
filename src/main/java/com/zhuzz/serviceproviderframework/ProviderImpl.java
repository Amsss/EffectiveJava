package com.zhuzz.serviceproviderframework;


public class ProviderImpl implements Provider{

	@Override
	public Service newService() {
		// TODO Auto-generated method stub
		return new ServiceImpl();
	}

}
