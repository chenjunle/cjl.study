package cjl.study.app;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cjl.study.mapper.UserMapper;

public class App {

	public static void main(String[] args){
		try(Reader reader = Resources.getResourceAsReader("mybatis.xml");){
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = factory.openSession();
			UserMapper userMapper = session.getMapper(UserMapper.class);
			System.out.println(userMapper.selectAll().size());
			System.out.println(userMapper.selectAll().get(0));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
