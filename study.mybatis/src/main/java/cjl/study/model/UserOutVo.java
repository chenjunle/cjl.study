package cjl.study.model;

public class UserOutVo extends User{

	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "UserOutVo [teacher=" + teacher + "]"+super.toString();
	}
}
