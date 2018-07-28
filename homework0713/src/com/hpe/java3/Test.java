package com.hpe.java3;

public class Test {

	public static void main(String[] args) {
		Addition addition = new Addition();

		int aInt, bInt;
		aInt = bInt = 2;

		long aLong, bLong;
		aLong = bLong = 2;

		float aFloat, bFloat;
		aFloat = bFloat = 2;

		double aDouble, bDouble;
		aDouble = bDouble = 2;

		String aString, bString;
		aString = bString = "1";

		System.out.println(addition.add(aInt, bInt));
		System.out.println(addition.add(aLong, bLong));
		System.out.println(addition.add(aFloat, bFloat));
		System.out.println(addition.add(aDouble, bDouble));
		System.out.println(addition.add(aString, bString));
	}
}
