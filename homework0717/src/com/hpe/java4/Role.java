package com.hpe.java4;
/**
 * 
 * @author chaoling
 * @date 2018年7月17日下午7:26:41
 * @Description
 */
public abstract class Role {

	private String name;
	private int age;
	private String sex;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}

	public Role() {
		super();
		System.out.println("Role：无参构造器");
	}

	public Role(String name, int age, String sex) {
		this();
		this.name = name;
		this.age = age;
		this.sex = sex;
		System.out.println("Role：有参构造器");
	}
	
	public abstract void play();
	
	public void say(){
		System.out.println(" Role:Say hello");
	}
	
	public final void sing(){
		System.out.println("Role:singing...");
	}
	
}
