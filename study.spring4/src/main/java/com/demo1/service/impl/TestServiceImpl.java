package com.demo1.service.impl;

import org.springframework.stereotype.Service;

import com.demo1.service.TestService;

public class TestServiceImpl implements TestService {

	@Override
	public String sayHello() {
		return "sayHello";
	}

}
