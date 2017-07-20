package com.demo2.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo2.config.DemoConfig;
import com.demo2.service.DemoAnnocationService;
import com.demo2.service.DemoService;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(DemoConfig.class);
		DemoAnnocationService annService = a.getBean(DemoAnnocationService.class);
		DemoService service = a.getBean(DemoService.class);
		service.add();
		annService.add();
	}
}
