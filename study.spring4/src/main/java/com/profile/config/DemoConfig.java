package com.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.profile.bean.DemoBean;

@Configuration
public class DemoConfig {
	@Bean
	@Profile("dev")
	public DemoBean demoBean(){
		return new DemoBean("dev");
	}
	@Bean
	@Profile("test")
	public DemoBean demoBean2(){
		return new DemoBean("test");
	}
}
