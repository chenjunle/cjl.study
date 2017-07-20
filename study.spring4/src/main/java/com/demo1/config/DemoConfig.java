package com.demo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo1.service.Test2Service;
import com.demo1.service.TestService;
import com.demo1.service.impl.Test2ServiceImpl;
import com.demo1.service.impl.TestServiceImpl;

@ComponentScan(basePackages="com.demo1.service")
@Configuration
public class DemoConfig {

	@Bean
	TestService testService(){
		return new TestServiceImpl();
	}
	
	@Bean
	Test2Service test2Service(){
		return new Test2ServiceImpl(testService());
	}
	
}
