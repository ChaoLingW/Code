package com.hpe.java2;

/**
 * 
 * @author chaoling
 * @date 2018年7月17日下午7:10:54
 * @Description
 */
public class Bike implements Vehicle{

	@Override
	public void start() {
		System.out.println("Bike start！");
	}

	@Override
	public void stop() {
		System.out.println("Bike stop!");
	}
}
