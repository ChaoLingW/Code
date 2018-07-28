package com.hpe.java;

import com.hpe.java5.CommonEmployee;
import com.hpe.java5.Employee;
import com.hpe.java5.Manager;

public class Test1 {

	public static void main(String[] args) {
		//创建Manager类的对象，并调用work()
		Employee manager = new Manager();
		manager.work();
		
		//创建CommonEmployee类的对象，并调用work()
		Employee commonEmployee = new CommonEmployee();
		commonEmployee.work();
	}
}
