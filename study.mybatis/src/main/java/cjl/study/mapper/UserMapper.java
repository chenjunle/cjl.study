package cjl.study.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cjl.study.model.Teacher;
import cjl.study.model.User;
import cjl.study.model.UserOutVo;

public interface UserMapper {

	List<User> selectAll();
	
	int addUser(User user);
	
	int addUser2(User user);
	
	List<User> selectByNameAndSexArg(String name,Integer sex);

	List<User> selectByNameAndSexParam(String name,Integer sex);
	
	List<User> selectByNameAndSexMap(Map<String,Object> map);
	
	List<User> selectByNameAndSexAnnotation(@Param("name") String name,@Param("sex") Integer sex);
	
	List<User> selectByNameAndSexClass(User user);
	
	UserOutVo selectById(Integer id);
	
	UserOutVo selectById2(Integer id);
	
	UserOutVo selectById3(Integer id);
	
	UserOutVo selectById4(Integer id);
	
	Teacher selectTeacherById(Integer id);
	
	Map<String,Object> selectByIds(Integer id);
}
