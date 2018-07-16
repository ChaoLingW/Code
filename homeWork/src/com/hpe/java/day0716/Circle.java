package com.hpe.java.day0716;
/**
 * 
 * @author chaoling
 * @date 2018年7月16日下午6:58:56
 * @Description
 */
public class Circle {

	private float radius;//存放圆的半径

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public Circle() {
		super();
		radius = 0;//将半径设为0
	}

	public Circle(float r) {
		super();
		this.radius = r;//将半径初始化为r
	}
	
	//获取圆的面积
	public double getArea(){
		//PI*R*R
		return Math.pow(this.radius, 2)*Math.PI;
	}
	
	//获取圆的周长
	public double getPerimeter(){
		return 2*this.radius*Math.PI;
	}
	
	//将圆的半径、周长、面积输出到屏幕
	public void show(){
		System.out.println("半径" + this.getRadius());
		System.out.println("周长" + this.getPerimeter()); 
		System.out.println("面积" + this.getArea());
	}
	
}
