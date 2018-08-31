package com.hpe.po;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String realName;
	private String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public User(int id, String username, String password, String realName, String sex) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realName = realName;
		this.sex = sex;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", realName=" + realName
				+ ", sex=" + sex + "]";
	}
	
}
