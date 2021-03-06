package com.hpe.java3;

/**
 * 
 * @author chaoling
 * @date 2018年7月16日下午7:11:07
 * @Description
 */
public class Cylinder extends Circle{
	
	private float hight;	//圆柱体的高

	public Cylinder() {
		super();
	}

	public Cylinder(float r, float h) {
		super(r);
		this.hight = h;
	}

	//获取圆柱体的体积
	public double getVolume(){
		//底面积*高
		return super.getArea()*this.hight;
	}
	
	//获取圆柱的表面积
	@Override
	public double getArea() {
		//2*底面积+周长*高
		return 2*super.getArea()+this.hight*super.getPerimeter();
	}
	
	//输出圆柱的半径，圆面积，圆周长，体积
	@Override
	public void show() {
		System.out.println("半    径" + this.getRadius());
		System.out.println("表面积" + this.getArea());
		System.out.println("圆周长"+super.getPerimeter());
		System.out.println("体    积" + this.getVolume());
	}
	

}
