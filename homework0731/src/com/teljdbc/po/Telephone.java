package com.teljdbc.po;
/**
 * @Description: 实体类
 * @author chaoling
 * @date 2018年7月29日下午1:31:10
 */
public class Telephone {
	
	private int id;
	private String name;
	private String sex;
	private int age;
	private String tel;
	private String qq;
	private String address;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getQq() {
		return qq;
	}
	
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public Telephone(int id, String name, String sex, int age, String tel, String qq, String address) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.qq = qq;
		this.address = address;
	}

	public Telephone() {
		super();
	}

	@Override
	public String toString() {
		return "姓名:" + name + ", 性别:" + sex + ", 年龄:" + age + ", 电话:" + tel + ", Q  Q:" + qq
				+ ", 地址:" + address;
	}
}
