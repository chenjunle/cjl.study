package com.demo1.service.impl;

import com.demo1.service.Test2Service;
import com.demo1.service.TestService;

public class Test2ServiceImpl implements Test2Service {

	TestService testService;
	
	@Override
	public void println() {
		System.out.println(testService.sayHello());
	}

	public Test2ServiceImpl(TestService testService) {
		super();
		this.testService = testService;
	}
	public TestService getTestService() {
		return testService;
	}
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
}
