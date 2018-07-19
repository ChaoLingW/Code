package com.hpe.java;

import org.junit.Test;

public class StringTest {

	@Test
	public void test1(){
		
		String str1 = "abc";
		
		String str2 = "abc";
		
		String str3 = new String("abc");
		
		System.out.println(str1.equals(str2));//true
		
		System.out.println(str1.equals(str3));//true
		
		System.out.println(str1 == str2);//true
		
		System.out.println(str1 == str3);//false
		
		str1 += "def";
		System.out.println(str1);//abcdef
		System.out.println(str2);//abc
		System.out.println(str1 == str2);//false
		
//		String是长度不可变的字符序列，不要频繁的对其进行字符串的拼接

//		如果需要频繁的对进行拼接，建议使用StringBuffer类
//		    StringBuffer是长度可变的字符序列
		StringBuffer sb = new StringBuffer();
		//通过append拼接字符串
		sb.append("abc");//扩容
		sb.append("def").append("ghi").append(1);
		System.out.println(sb);
		
		//String 与StringBuffer的区别
		//String是长度不可变的字符序列
//		//StringBuffer是长度可变的字符串序列（扩容）
//		StringBuffer,可变字符序列，线程安全，效率低
//		StringBuilder:可变序列，线程不安全，效率高
	}
	
	@Test
	public void test2(){
		
		String str1 = "abcdef";
		System.out.println(str1.startsWith("def"));//false
		System.out.println(str1.endsWith("f"));//true
		
		System.out.println(str1.compareTo("Abcdef"));//按字典的顺序比较
		
		System.out.println(str1.compareToIgnoreCase("Abcdef"));
		
		System.out.println(str1.replace('b', 'B'));
		System.out.println(str1.replaceAll("ef", "EF"));
	
		String str2 = "ABC";
		String str3 = "def";
		
		System.out.println(str2.concat(str3));
		
		System.out.println(str2.indexOf("A"));//0
		System.out.println(str2.indexOf("AB"));//0
		System.out.println(str2.indexOf("g"));//-1
		System.out.println(str2.indexOf("AC"));//-1
		
		String str4 = "abcabc";
		System.out.println(str4.indexOf("a", 1));//3
		System.out.println(str4.substring(2));
		System.out.println(str4.substring(2,3));
		
		String str5 = " a b c  ";
		System.out.println(str5.trim());
		
		String str12 = "a,b,c,d,e,f";
		
		String[] arr = str12.split(",");
		for(String str:arr)
			System.out.println(str);
	
		char c = str12.charAt(2);
		System.out.println(c);
		
	}
	
	
	
	
	
	
	
	
	
}
