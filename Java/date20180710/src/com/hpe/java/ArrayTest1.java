package com.hpe.java;

/**
 * 
 * @author chaoling
 * @date 2018年7月10日上午10:22:19
 * @Description
 */
public class ArrayTest1 {

	public static void main(String[] args) {

		// test1();
		// test2();
		//test3();
		//test4();
		test5();

	}

	// 数组的遍历方式一：使用for循环
	public static void test1() {

		int[] a = { 2, 4, 3, 1, 8, 7, 9 };

		// for循环实现遍历
		// 0-a.length -1
		for (int i = 0; i < a.length; i++) {

			System.out.println(a[i]);

		}
	}

	// 使用增强for循环(foreach)遍历
	public static void test2() {

		int[] a = { 2, 4, 3, 1, 8, 7, 9 };

		// foreach实现遍历
		// for(类型 变量名：数组名)
		for (int i : a) {

			System.out.println(i);

		}

	}

	// 遍历String(for循环)
	public static void test3() {
		
		String[] strArray = { "a", "b", "c", "d" };

		for (int i = 0; i < strArray.length; i++)
			System.out.println(strArray[i]);

	}

	// 遍历String(foreach)
	public static void test4() {
		
		String[] strArray = { "a", "b", "c", "d" };

		for (String str : strArray)
			System.out.println(str);

	}

	public static void test5(){
		
		//创建一个数组，数组中的元素都是Persion类的对象，怎么声明
		//左边：Persion是数组中元素的类型
		//[]：一维数组
		//arr：数组名
		//右边：Persion是数组中元素的类型
		//3：数组中元素的个数
		Person[] arr = new Person[3];//数组中都是Persion类型
		
		Person p1 = new Person(11, "张三");
		arr[0] = p1;
		
		Person p2 = new Person(12, "李四");
		arr[1] = p2;
		Person p3 = new Person(13, "王五");
		arr[2] = p3;
		
		//如何得到数组中所有Persion对象的名字
		//得到所有对象 -->所有名字
		for(int i = 0; i < arr.length; i++){
			
			Person person = arr[i];
			
			System.out.println(person.getName() + "!");
		}
		
		for(Person person : arr)
			System.out.println(person.getName() + "!");
		
	}
	
}
