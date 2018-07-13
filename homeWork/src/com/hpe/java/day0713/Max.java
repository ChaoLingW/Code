package com.hpe.java.day0713;
/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午7:56:01
 * @Description
 */
/*定义3个重载方法max，第一个方法求两个int值中的最大值，第2个方法求三个int值中的最大值，第3个方法求四个int值中的最大值，并分别调用三个方法
*/
public class Max {

	// 求两个int值中的最大值
	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// 求三个int值中的最大值
	public static int max(int a, int b, int c) {
		return (a > b) ? (a > c ? a : c) : (b > c ? b : c);
	}

	// 求四个int值中的最大值
	public static int max(int a, int b, int c, int d) {

		/*//首先将定义一个变量将其中的一个参数赋值给它，之后与其它的参数比较，如果参数的值大于变量，则将值赋值给变量
		 * int max = a;
		 * if(max <b) max = b; 
		 * if(max <c) max = c; 
		 * if(max <d) max = d;
		 */
		
		// 利用分组思想进行比较 两两或者三三或者二三比较
		int x = (a > b) ? a : b;
		int y = (c > d) ? c : d;
		return (x > y) ? x : y;
	}

}
