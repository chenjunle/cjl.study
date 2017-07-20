package com.demo3.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo3.config.DemoConfig;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	}
	
}
