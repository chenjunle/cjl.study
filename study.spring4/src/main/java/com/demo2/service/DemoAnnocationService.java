package com.demo2.service;

import org.springframework.stereotype.Service;

import com.demo2.annotation.CjlStudy;

@Service
public class DemoAnnocationService {

	@CjlStudy(name = "基于注解的切面")
	public void add(){}
}
