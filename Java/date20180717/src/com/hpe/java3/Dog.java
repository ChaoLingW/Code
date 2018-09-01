package com.hpe.java3;


//既有继承父类，也有实现接口；先继承，后实现
//实现类去实现接口，接口中的抽象方法必须实现，否则这个类就是抽象类
//java中类是单继承，接口是多继承（一个类可以实现多个接口，多个接口之间用,隔开）
public class Dog extends Animal implements IWatchDoor,IBite{

	@Override
	public void shout() {
		System.out.println("汪汪汪");
	}

	@Override
	public void watchDor() {
		System.out.println("狗看门");
	}

	@Override
	public void bite() {
		System.out.println("狗咬人");
	}
	
	

}
