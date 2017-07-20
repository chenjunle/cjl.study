package com.demo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.demo2.aspect.Aspects;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages="com.demo2")
public class DemoConfig {
	@Bean
	Aspects aspects(){
		return new Aspects();
	}
}
