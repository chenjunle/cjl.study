package com.demo3.bean;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class BeanTwo {

	public BeanTwo(){
		System.out.println("调用BeanTwo的构造方法");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("BeanTwo的初始化方法(在构造方法完成后执行)");
	}
}
