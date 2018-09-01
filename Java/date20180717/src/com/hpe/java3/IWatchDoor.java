package com.hpe.java3;

//抽象方法(功能定义，具体的实现交由实现类)、常量
//接口中的方法默认为抽象方法//pulic abstract
//常量默认为 public static final
public interface IWatchDoor {
	
	public abstract void watchDor();//定义看门的功能
	
	public static final int I = 1;
	/*
	static void staticMethod(){
		
	}
	
	default void defaultMethod(){
		
	}*/
}
