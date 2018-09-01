package com.hpe.java1;
/**
 * 
 * @author chaoling
 * @date 2018年7月16日上午11:27:54
 * @Description
 */

//final 修饰符
//修饰什么？class、方法、属性
//class：不能被继承（不能有子类），可以实例化。比如String类

//方法：不能被重写，比如object的wait();

//属性：常量必须设置初始值(显示赋值)，且不能修改(创建对象后，常量有值就行)Math.PI
//final标记的成员变量必须在声明的同时或在每个构造函数或代码块中显示赋值，然后才能使用
public class Person {
	
	private final int age;
	
	
	
	public Person() {
		super();
		age = 1;
	}



	public final void eat(){
		
		System.out.println("eating");
	}
	
	

}

/*class A extends String{
	
}
*/
/*
class A extends Person{
	
	public void eat(){
		
		System.out.println("eating");
	}
	
}
*/