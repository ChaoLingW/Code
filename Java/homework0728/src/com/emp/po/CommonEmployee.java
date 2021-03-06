package com.emp.po;
/**
 * @Description: 子类，普通员工的具体类，重写工资计算方法
 * @author chaoling
 * @date 2018年7月28日上午11:04:56
 */

public class CommonEmployee extends Employee{
	
	public CommonEmployee() {
		super();
	}

	public CommonEmployee(String iD, String name, String postition, int holiday, double salary) {
		super(iD, name, postition, holiday, salary);
	}

	/*
	 * @see com.hpe.po.Employee#sumSalary()
	 * @return
	 */
	@Override
	public double sumSalary() {
		return super.sumSalary() + super.getSalary()*(0.1+0.5) + 200;
	}
}
