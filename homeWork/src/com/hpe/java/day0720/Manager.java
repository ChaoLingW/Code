package com.hpe.java.day0720;

/**
 * 
 * @author chaoling
 * @date 2018年7月16日下午8:26:58
 * @Description
 */
public class Manager extends Employee{
	
	public Manager() {
		super();
	}

	public Manager(String iD, String name, String postition, int holiday, double salary) {
		super(iD, name, postition, holiday, salary);
	}

	public double sumSalary() {
		
		return super.sumSalary() + super.getSalary()*(1+0.08+0.3)+2000+3000;
	}
}
