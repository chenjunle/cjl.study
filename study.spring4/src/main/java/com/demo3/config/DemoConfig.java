package com.demo3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo3.bean.BeanOne;

@Configuration
@ComponentScan("com.demo3")
public class DemoConfig {

	@Bean(initMethod="init")
	BeanOne beanOne(){
		return new BeanOne();
	}
	
}
