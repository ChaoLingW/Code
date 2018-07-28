package com.hpe.java3;

/**
 * 
 * @author chaoling
 * @date 2018年7月17日下午7:13:51
 * @Description
 */
public class FireProofDoor extends Door implements FireSafe{

	@Override
	public void fireProof() {
		System.out.println("防火");
	}

	@Override
	public void open() {
		System.out.println("FireProofDoor open");
	}

	@Override
	public void close() {
		System.out.println("FireProofDoor close");		
	}
}
