package com.cjl.study.study.mybatis;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

/**
 * 公共mybatis测试类
 * @author cjl
 *
 */
public class BaseTest {

	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void init(){
		try(Reader reader = Resources.getResourceAsReader("mybatis.xml");){
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}

}
