package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

	@RequestMapping("/test")
	public asd test(){
		return new asd("帅");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	class asd{
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public asd(String name) {
			super();
			this.name = name;
		}
	}
}
