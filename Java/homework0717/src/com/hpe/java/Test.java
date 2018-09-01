package com.hpe.java;

import com.hpe.java1.Car;
import com.hpe.java1.Motorbike;
import com.hpe.java1.Vehicle;
import com.hpe.java3.BulletProofDoor;
import com.hpe.java3.FireProofDoor;
import com.hpe.java4.Employee;
import com.hpe.java5.CommonEmployee;
import com.hpe.java5.Manager;

/**
 * 
 * @author chaoling
 * @date 2018年7月17日下午6:16:01
 * @Description
 */
public class Test {

	public static void main(String[] args) {

		//创建Car类的对象，并调用wheelsNum和run
		Vehicle car = new Car();
		car.wheelsNum();
		car.run();
		
		//创建Motorbike类的对象，并调用wheelsNum和run
		Vehicle motorbike = new Motorbike();
		motorbike.wheelsNum();
		motorbike.run();
		
		//创建FireProofDoor的对象，并调用所有的函数
		FireProofDoor fireProofDoor = new FireProofDoor();
		fireProofDoor.open();
		fireProofDoor.fireProof();
		fireProofDoor.close();

		//创建BulletProofDoor的对象，并调用所有的函数
		BulletProofDoor bulletProofDoor = new BulletProofDoor();
		bulletProofDoor.open();
		bulletProofDoor.bulletProof();
		bulletProofDoor.close();
		
		//题四
		System.out.println("题四");
		System.out.println("为company赋值");
		
		Employee.setCompany("HP");
		System.out.println("company赋值完毕:" +Employee.getCompany() );
		
		Employee e1 = new Employee("001");
		Employee e2 = new Employee("张三", 12, "男", "001", 2000);
		System.out.println("输出信息");
		System.out.println(e1);
		System.out.println(e2);
		
		e1.play();
		e1.sing();
	}

}
