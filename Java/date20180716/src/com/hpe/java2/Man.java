package com.hpe.java2;

public class Man extends Person{
	
	//重写Person的eat方法
	@Override
	public void eat() {
		System.out.println("男人吃饭要细嚼慢咽");
	}

	//特有的
	public void drink(){
		
		//
		System.out.println("drinking...");
	}
}
