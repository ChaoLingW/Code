package com.empmap.po;

public class CommonEmployee extends Employee{
	
	public CommonEmployee() {
		super();
	}

	public CommonEmployee(String iD, String name, String postition, int holiday, double salary) {
		super(iD, name, postition, holiday, salary);
	}

	@Override
	public double sumSalary() {
		return super.sumSalary() + super.getSalary()*(0.1+0.5) + 200;
	}
}
