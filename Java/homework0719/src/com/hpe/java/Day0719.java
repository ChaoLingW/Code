package com.hpe.java;

import org.junit.Test;

public class Day0719 {
	
	/*
	 * 给定一个字符串数组{"nba","abc","cba","zz","qq","haha"}，请按照字典顺序进行从小到大的排序。
	 * 	请统计"nba"在字符串"nbaernbatynbauinbaopnba"中出现的次数
	 */
	@Test
	public void sortStringArray(){
		
		String[] arr = {"nba","abc","cba","zz","qq","haha"};
		
		//冒泡排序
		for(int i = 0; i < arr.length-1;i++){
			for(int j = 0; j < arr.length-i-1;j++){
				//利用String类的compareTo()函数进行比较，返回值为正数，说明前面的大于后面，需要交换
				if(arr[j].compareTo(arr[j+1])>0){
					//交换
					String temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		//遍历
		for(String str:arr)
			System.out.print(str + " ");
	}
	
	/*
	 * equals()方法练习s----被大多数类重写（查API看一下）
	 * 	定义两个String类型的变量，str和str1,如下
	 * 	String str = new String(“hello”);
	 * 	String str1 = “hello”;
	 * 	分别用==和equals比较这str和str1是否相等，并打印出来，并加注释说明相等和不相等的原因。
	 */
	@Test
	public void countString(){
		
		String str = "nbaernbatynbauinbaopnba";//字符串
		String seekStr = "nba";//待统计的字符串
		int count = 0;//计数
		int index = 0;//在字符串中的位置
		
		//循环，查找的位置在0-str.str.length()-seekStr.length()
		for(int i = index; i < str.length()-seekStr.length(); i++){
			//获取待统计的字符串在字符串中的索引
			index =str.indexOf(seekStr,i);
			//如果大于0说明存在，
			if(index >= 0){
				//将i值变为查到的index+seekStr.length()
				i = index + seekStr.length();
				//次数加一
				count ++;
			}
		}
		//输出
		System.out.println(seekStr + "出现的次数为："+count);
	}
	
	/*
	 * equals()方法练习（提高）---提示：需要在Person类中复写equals()
	 * 自定义一个Person类，有name和age属性，并建一个两个参数的构造函数，
	 * 在主函数main中，定义两个Person对象p1和p2，如下，调用equals比较这个两个对象是否相等。
	 * Person p1 = new Person(“xiaowang”,12);
	 * Person p2 = new Person(“xiaowang”,12);
	 * p1.equals(p2);
	 */
	@Test
	public void equalsTest(){
		
		String str = new String("hello");
		String str1 = "hello";
		
		System.out.println(str + "==" + str1 +"  "+(str == str1));
		//false   ==在比较引用数据类型是比较的是地址值，因此结果为false
		
		System.out.println(str + ".equals(" + str1 +")  " + str.equals(str1));
		//true  String重写了equals()在String类中，该方法比较的是两个字符串中的内容
		
		Person p1 = new Person("xiaowang",12);
		Person p2 = new Person("xiaowang",12);
		
		//Person中重写了equals
		System.out.println(p1.equals(p2));//true
	}
	
	/*
	 * String类练习
	 * 给定一个字符串String str=” Hello World”,返回长度，
	 * 返回O第一次出现的索引，返回最后一个O的索引，
	 * 把所有的l都替换为m，
	 * 把字符串str按空格分割为两个字符串，
	 * 最后比较两个字符串（equals）。
	 * 每一步操作结果输出打印。
	 */
	@Test
	public void stringTest(){
		
		String str = "Hello World";
		
		System.out.println("字符串的长度为：" + str.length());
		System.out.println("返回第一个o出现的索引：" + str.indexOf('o'));
		System.out.println("最后一个o出现的索引：" + str.lastIndexOf('o'));
		System.out.println("替换前的字符串" + str);
		
		String newStr = str.replace('l', 'm');
		
		System.out.println("替换后的字符串：" + newStr);
		System.out.println("将字符串按空格分割后");
	
		String[] arr = str.split(" ");
		
		for(String s :arr )
			System.out.println(s);
		
		System.out.println("利用equals比较的结果：" + arr[0].equals(arr[1]));
	}
}
