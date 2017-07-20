package com.demo3.bean;

public class BeanOne {
	public BeanOne(){
		System.out.println("调用BeanOne的构造方法");
	}
	
	public void init(){
		System.out.println("BeanOne的初始化方法(在构造方法完成后执行)");
	}
}
