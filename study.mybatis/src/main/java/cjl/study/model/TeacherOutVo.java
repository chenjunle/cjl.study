package cjl.study.model;

import java.util.List;

public class TeacherOutVo extends Teacher{

	private static final long serialVersionUID = 1L;
	
	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
