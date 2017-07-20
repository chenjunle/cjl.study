package com.cjl.study.study.mybatis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import cjl.study.mapper.UserMapper;
import cjl.study.model.Teacher;
import cjl.study.model.User;
import cjl.study.model.UserOutVo;

public class InsertTest extends BaseTest{
	
	public static Logger logger = LoggerFactory.getLogger(InsertTest.class);
	
	@Test
	public void testAddUser(){
		SqlSession session = getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setName("陈俊乐");
		user.setSex(1);
		Date now = new Date();
		user.setDate(now);
		user.setDateTime(now);
		user.setTime(now);
		user.setTimestamp(now);
		int num = userMapper.addUser(user);
		System.out.println("影响行数:"+num);
		System.out.println(user);
		session.commit();
	}
	
	@Test
	public void testSelectAll(){
		SqlSession session = getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		System.out.println(userMapper.selectAll().get(userMapper.selectAll().size()-1));
	}
	
	@Test
	public void testAddUser2(){
		SqlSession session = getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setName("陈俊乐");
		user.setSex(1);
		Date now = new Date();
		user.setDate(now);
		user.setDateTime(now);
		user.setTime(now);
		user.setTimestamp(now);
		int num = userMapper.addUser2(user);
		System.out.println("影响行数:"+num);
		System.out.println(user);
		session.commit();
	}
	
	@Test
	public void testSelectByNameAndSex(){
		SqlSession session = getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		System.out.println("----------------------------使用默认参数名arg 0-N----------------------------");
		List<User> user = userMapper.selectByNameAndSexArg("cjl",1);
		user.forEach(System.out::println);
		
		System.out.println("----------------------------使用默认参数名param 1-N----------------------------");
		user = userMapper.selectByNameAndSexParam("boboaisibi",2);
		user.forEach(System.out::println);
		
		System.out.println("----------------------------使用Map包装参数----------------------------");
		Map<String,Object> map = new HashMap<>();
		map.put("name","dagezz");
		map.put("sex", 2);
		user = userMapper.selectByNameAndSexMap(map);
		user.forEach(System.out::println);
		
		System.out.println("----------------------------使用@Param注解----------------------------");
		user = userMapper.selectByNameAndSexAnnotation("666",2);
		user.forEach(System.out::println);
		
		System.out.println("----------------------------使用类包装参数----------------------------");
		User users = new User();
		users.setName("dagezz");
		users.setSex(2);
		user = userMapper.selectByNameAndSexClass(users);
		user.forEach(System.out::println);
	}
	
	@Test
	public void testSelectById(){
		SqlSession session = getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserOutVo outVo = userMapper.selectById(1);
		System.out.println(outVo);
	}
	
	@Test
	public void testSelectById2(){
		SqlSession session = getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserOutVo outVo = userMapper.selectById2(1);
		System.out.println(outVo);
	}
	
	@Test
	public void testSelectById3(){
		SqlSession session = getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserOutVo outVo = userMapper.selectById3(1);
		System.out.println(outVo);
	}
	
	@Test
	public void testSelectTeacherById(){
		SqlSession session = getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		Teacher teacher = userMapper.selectTeacherById(1);
		System.out.println(teacher);
	}
	
	@Test
	public void testSelectById4(){
		SqlSession session = getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserOutVo outVo = userMapper.selectById4(1);
		logger.debug("调用getTeacher()");
		System.out.println(outVo.getTeacher());
	}
}
