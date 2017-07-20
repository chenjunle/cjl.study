package cjl.study.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cjl.study.model.Teacher;
import cjl.study.model.TeacherOutVo;

public interface TeacherMapper {

//	Teacher selectByIdAndName(@Param("id") Integer id,@Param("name") String name);
	
	List<TeacherOutVo> selectTeacherAndUser();
	
	TeacherOutVo selectById(Integer id);
	
	int updateById(Teacher teacher);
	
	Map<String,Object> selectByIds(Integer id);
	
}
