package com.hpe.po;

/**
 * TODO:user表对应的实体类
 * @author chaoling
 *
 */
public class User {

	private int id;
	private String userName;
	private String password;
	private String sex;
	private String hobbys;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getHobbys() {
		return hobbys;
	}
	
	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}
	
	public User(int id, String userName, String password, String sex, String hobbys) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.hobbys = hobbys;
	}
	
	
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", sex=" + sex + ", hobbys="
				+ hobbys + "]";
	}
	
}
