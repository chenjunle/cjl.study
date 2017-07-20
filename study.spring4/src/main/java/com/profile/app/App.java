package com.profile.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.profile.bean.DemoBean;
import com.profile.config.DemoConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(DemoConfig.class);
		context.refresh();
		
		DemoBean  demoBean = context.getBean(DemoBean.class);
		demoBean.println();
	}
}
