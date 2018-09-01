package com.hpe.java;
/**
 *  
 * @author chaoling
 * @date 2018年7月13日下午6:00:17
 * @Description
 */
public class TestCylinder {

	public static void Test() {
		
		//创建Cylinder对象
		CylinderHomework1 cylinder = new CylinderHomework1();
		
		//设置圆柱的底面半径和高
		cylinder.setRadius(10);
		cylinder.setLength(10);
		
		//输出圆柱的体积
		System.out.println("圆柱的体积为：" + cylinder.findVolume());
		
	}
	
}
