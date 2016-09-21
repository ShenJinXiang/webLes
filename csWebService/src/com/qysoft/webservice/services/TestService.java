package com.qysoft.webservice.services;

public class TestService implements IService {

	@Override
	public String jk1(String str) {
		return str + "111";
	}

	@Override
	public String jk2(String str) {
		return str + "222";
	}

}
