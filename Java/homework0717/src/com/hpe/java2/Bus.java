package com.hpe.java2;

/**
 * 
 * @author chaoling
 * @date 2018年7月17日下午7:10:59
 * @Description
 */
public class Bus implements Vehicle{

	@Override
	public void start() {
		System.out.println("Bus start");
	}

	@Override
	public void stop() {
		System.out.println("Bus stop");
	}
}
