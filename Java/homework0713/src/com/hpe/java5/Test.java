package com.hpe.java5;

public class Test {
	public static void main(String[] args) {
		// 调用max比较大小
		int aMax = 1;
		int bMax = 2;
		int cMax = 3;
		int dMax = 4;

		System.out.println(Max.max(aMax, bMax));
		System.out.println(Max.max(cMax, dMax, aMax));
		System.out.println(Max.max(aMax, bMax, cMax, dMax));

	}
}
