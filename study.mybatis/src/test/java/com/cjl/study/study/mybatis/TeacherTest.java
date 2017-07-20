package com.cjl.study.study.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cjl.study.mapper.TeacherMapper;
import cjl.study.mapper.UserMapper;
import cjl.study.model.TeacherOutVo;

public class TeacherTest extends BaseTest{

	@Test
	public void testSelectTeacherAndUserById(){
		SqlSession session = getSqlSession();
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		List<TeacherOutVo> outVo = teacherMapper.selectTeacherAndUser();
		System.out.println(outVo);
		System.out.println(outVo.get(0).getId() == outVo.get(1).getId());
	}
	
	
	@Test
	public void testSelectById(){
		SqlSession session = getSqlSession();
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		TeacherOutVo outVo = teacherMapper.selectById(1);
		outVo.setName("志骐你有点弱啊");
		System.out.println("准备执行第二遍查询");
		TeacherOutVo outVo2 = teacherMapper.selectById(1);
		System.out.println(outVo2.getName());
		System.out.println("更新记录");
		outVo.setName("ASJDKSAJD");
		teacherMapper.updateById(outVo);
		System.out.println("准备执行第三遍查询");
		TeacherOutVo outVo3 = teacherMapper.selectById(1);
		System.out.println("准备执行第四遍查询");
		TeacherOutVo outVo4 = teacherMapper.selectById(1);
		
	}
	
	@Test
	public void testTwoCache() throws InterruptedException{
		TeacherOutVo outVo = null;
		TeacherOutVo outVo2 = null;
		TeacherOutVo outVo3 = null;
		try(SqlSession session = getSqlSession()){
			TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
			outVo = teacherMapper.selectById(1);
			System.out.println(outVo.getName());
			outVo.setName("真的是只读么？我不理解");
		}
		try(SqlSession session = getSqlSession()){
			TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
			outVo2 = teacherMapper.selectById(1);
		}
		System.out.println(outVo == outVo2);
		System.out.println(outVo2.getName());
		Thread.sleep(3000);
		try(SqlSession session = getSqlSession()){
			TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
			outVo3 = teacherMapper.selectById(1);
		}
	}
	
	@Test
	public void testSelectByIdS(){
		SqlSession session = getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Map<String, Object> map = mapper.selectByIds(1);
		Set<Entry<String, Object>> entity = map.entrySet();
		for(Entry<String, Object> temp:entity){
				System.out.println(temp.getKey()+":"+temp.getValue());
		}
	}
	
}
