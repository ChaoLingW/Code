package com.hpe.java.day0713;
/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午5:41:44
 * @Description
 */

/*编写一个圆类Circle，该类拥有：
①一个成员变量
Radius（私有，浮点型）；  // 存放圆的半径；
②两个构造方法
Circle( )                 // 将半径设为0
Circle(double  r )         //创建Circle对象时将半径初始化为r
③ 三个成员方法
double getArea( )       //获取圆的面积
double getPerimeter( )   //获取圆的周长
void  show( )          //将圆的半径、周长、面积输出到屏幕
*/
public class CircleHomework2 {
	
	private double Radius;//存放圆的半径

	//将半径设为0
	public CircleHomework2() {
		super();
		this.Radius = 0;
	}

	//将半径初始化为r
	public CircleHomework2(double r) {
		super();
		Radius = r;
	}
	
	//获取圆的面积
	public double getArea(){
		//返回圆的面积
		return Math.pow(this.Radius, 2)*Math.PI;
	}
	
	//获取圆的周长
	public double getPerimeter(){
		//圆的周长
		return this.Radius*2*Math.PI;
	}
	
	//将圆的半径、周长、面积输出到屏幕
	public void show(){
		
		///将圆的半径、周长、面积输出
		System.out.println("圆的半径：" + this.Radius);
		System.out.println("圆的周长：" + this.getPerimeter());
		System.out.println("圆的面积：" + this.getArea());
	}

}
