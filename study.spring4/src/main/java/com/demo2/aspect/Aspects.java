package com.demo2.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import com.demo2.annotation.CjlStudy;

@Aspect
public class Aspects {
	@Pointcut("@annotation(com.demo2.annotation.CjlStudy)")
	public void pointAnnotaion(){};
	@After("pointAnnotaion()")
	public void after(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		CjlStudy ann = method.getAnnotation(CjlStudy.class);
		System.out.println("注解拦截已成功,注解的值为:"+ann.name());
	}
	@Before("execution(* com.demo2.service.DemoService.*(..))")
	public void before(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法拦截已成功，方法名为"+method.getName());
	}
}
