package com.demo1.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo1.config.DemoConfig;
import com.demo1.service.Test2Service;
import com.demo1.service.TestService;
import com.demo1.service.impl.Test2ServiceImpl;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		Test2ServiceImpl test2 = context.getBean(Test2ServiceImpl.class);
		TestService test = context.getBean(TestService.class);
		test2.println();
		System.out.println(test2.getTestService() == test);
	}
	
}
