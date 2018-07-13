package com.hpe.java.day0713;
/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午5:41:32
 * @Description
 */
public class CylinderHomework1 extends CircleHomework1{
	
	private double length;

	//将length属性初始化为1
	public CylinderHomework1() {
		super();
		this.length = 1;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public double findVolume(){
		//计算圆柱的体积并返回
		return this.findArea()*this.length;
	}
	
	
	
	
	
	
	
	

}
