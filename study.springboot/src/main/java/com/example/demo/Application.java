package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.study.bean.Study;

import study.startpom.hello.config.HelloAutoConfigure;
import study.startpom.hello.service.HelloService;

@SpringBootApplication(scanBasePackages="com.study.bean")
public class Application {

	
	public static void main(String[] args) {
		ConfigurableApplicationContext a = SpringApplication.run(Application.class,args);
		HelloService helloService = a.getBean(HelloService.class);
		helloService.sayHello();
	}
}
