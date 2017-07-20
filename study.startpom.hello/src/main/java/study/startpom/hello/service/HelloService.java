package study.startpom.hello.service;

public class HelloService {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void sayHello(){
		System.out.println("Hello "+msg);
	}
	
}
