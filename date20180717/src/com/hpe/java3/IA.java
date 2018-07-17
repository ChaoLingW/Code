package com.hpe.java3;

//接口与接口之间的关系：继承（支持多继承）。一个接口可以去继承多个接口
public interface IA extends IWatchDoor,IBite{

	void a();
}
