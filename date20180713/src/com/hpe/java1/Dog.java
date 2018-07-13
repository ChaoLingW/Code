package com.hpe.java1;
/**
 * 
 * @author chaoling
 * @date 2018年7月13日上午10:30:36
 * @Description
 */
//继承
//如何实现继承：使用关键字extends
	//子类名（A） extends 父类名（B);
	//子类、派生类、SubClass
	//父类、基类、SuperClass
//会继承什么
	//属性、方法
	//会继承所有的属性和方法，但是对于private的不能直接访问
//构造函数不会被继承

//添加子类特有的属性和方法
public class Dog extends Animal{
	
	//子类特有的属性
	private String type;//种类
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//子类特有的方法
	public void watchDoor(){
		
		System.out.println("看门");
	}

	//子类可以重写父类中的方法，来表现自己的行为。当调用重写的方法时，调用的时是子类重写的方法
	//重写override
	//前提：子类继承父类，就可以父类的方法，方法名要一致，参数一致（个数与类型都一致），返回值也一致
	//@Override 修饰的方法必须是一个重写的方法
	@Override
	public void shout(){
		System.out.println("汪汪汪");
	}
	
}
