package com.hpe.java.day0717;
/**
 * 
 * @author chaoling
 * @date 2018年7月17日上午11:52:13
 * @Description
 */
public abstract class Employee {

	private String name;
	private String id;
	private double salary;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee() {
		super();
	}

	public Employee(String name, String id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public abstract void work();
}
