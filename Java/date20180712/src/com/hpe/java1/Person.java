package com.hpe.java1;

/**
 * 
 * @author chaoling
 * @date 2018年7月12日下午2:39:33
 * @Description
 */

//人类
//类的成员：属性、方法...
public class Person {

	//属性(局部变量)
	//访问修饰符：public protected private 缺省
	private int age;
	String name;
	String sex;
	
	//外部可以访问（设置age属性值）
	public void setAge(int age){
		
		//加入验证
		if(age>130||age<= 0){
			this.age = 1;
		}
		else
		//设置age的属性值
		this.age = age;
		
	}
	
	//获取age属性值
	public int getAge(){
		
		return this.age;
		
	}
	
	
	//方法
	//吃饭
	public void eat(){
		System.out.println("eating...");
		
	}
	
	//sayHello
	public void sayHello(){
		System.out.println("你好，我的名字是" + name);
	}
	
	public void showFields(){
		
		System.out.println(age + " " + name + " " + sex);
		
	}
	//重写toString
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
	
}
