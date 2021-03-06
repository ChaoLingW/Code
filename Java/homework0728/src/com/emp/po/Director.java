package com.emp.po;
/**
 * @Description: 子类，经理的具体类，重写工资计算方法
 * @author chaoling
 * @date 2018年7月28日上午11:06:25
 */
public class Director extends Employee{
	
	public Director() {
		super();
	}

	public Director(String iD, String name, String postition, int holiday, double salary) {
		super(iD, name, postition, holiday, salary);
	}
	
	/*
	 * @see com.hpe.po.Employee#sumSalary()
	 * @return
	 */
	@Override
	public double sumSalary() {
		return super.sumSalary() + super.getSalary()*(1+0.2+0.5)+500;
	}
}
