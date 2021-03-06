package hpe.bean;

public class User {
	
	// 简单类型 
	private String name;	//用户名
	private String pwd;		//密码

	public User() {
	}

	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", pwd=" + pwd + "]";
	}

	public void output() {
		System.out.println("out_____");
	}

}
