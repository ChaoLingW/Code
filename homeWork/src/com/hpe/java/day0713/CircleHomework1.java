package com.hpe.java.day0713;
/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午4:52:14
 * @Description
 */
public class CircleHomework1 {
	
	private double radius;
	
	//将radius的值设置为1
	public CircleHomework1() {
		this.radius = 1;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double findArea(){
		//计算圆的面积并返回
		return Math.pow(this.radius, 2) * Math.PI;
	}
	
}
