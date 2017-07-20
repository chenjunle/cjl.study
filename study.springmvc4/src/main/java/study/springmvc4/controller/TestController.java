package study.springmvc4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import study.springmvc4.bean.Test;

@Controller
@RequestMapping("/test")
public class TestController {

	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.debug("{}{}","呵呵哒","哼");
		return "index";
	}
	
	@RequestMapping(value="/test", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Test responsebody(){
		Test test = new Test();
		test.setAge(11);
		test.setName("cjl");
		return test;
	}
	
	@RequestMapping(value="/error", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Test error(@ModelAttribute("msg") String msg,Test test){
		throw new RuntimeException("这个接口是报错的,他所接收到的参数分别是:msg{"+msg+"},test{"+test.toString()+"}");
	}
	
}
