package com.emp.po;
/**
 * @Description: 子类，董事长的具体类，重写工资计算方法
 * @author chaoling
 * @date 2018年7月28日上午11:07:02
 */
public class Manager extends Employee{
	
	public Manager() {
		super();
	}

	public Manager(String iD, String name, String postition, int holiday, double salary) {
		super(iD, name, postition, holiday, salary);
	}

	/*
	 * @see com.hpe.po.Employee#sumSalary()
	 * @return
	 */
	@Override
	public double sumSalary() {
		
		return super.sumSalary() + super.getSalary()*(1+0.08+0.3)+2000+3000;
	}
}
