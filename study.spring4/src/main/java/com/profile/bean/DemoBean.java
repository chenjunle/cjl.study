package com.profile.bean;

public class DemoBean {
	private String content;
	public void println(){
		System.out.println(content);
	}
	public DemoBean(String content) {
		super();
		this.content = content;
	}
	public DemoBean() {
		super();
	}
}
