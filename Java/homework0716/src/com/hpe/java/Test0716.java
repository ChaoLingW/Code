package com.hpe.java;

import org.junit.Test;

import com.hpe.java1.Chess;
import com.hpe.java1.ChineseChess;
import com.hpe.java1.InternationalChess;
import com.hpe.java3.Circle;
import com.hpe.java3.Cylinder;
import com.hpe.java4.Student;

/**
 * 
 * @author chaoling
 * @date 2018年7月16日下午6:59:15
 * @Description
 */
public class Test0716 {

	@Test
	public void play() {

		// 定义Chess类的实例，并调用rule()
		Chess chess = new Chess();
		chess.rule();
		// 定义ChineseChess类的实例，并调用rule()
		Chess chinesneeChess = new ChineseChess();
		if (chinesneeChess instanceof ChineseChess)
			chinesneeChess.rule();
		// 定义InternationalChess类的实例，并调用rule()
		Chess internationalChess = new InternationalChess();
		if (internationalChess instanceof InternationalChess)
			internationalChess.rule();

	}

	// 第二题
	@Test
	public void test2() {

		for (int shi = 1; shi <= 9; shi += 2) {
			for (int ge = 2; ge <= 8; ge += 2) {
				for (int sh = 2; sh <= 8; sh += 2) {
					for (int g = 1; g <= 9; g += 2) {
						// 保存与个位相乘的数值，小于1000大于100
						int i = (shi * 10 + ge) * g;
						// 保存与十位相乘的数值，小于100大于10
						int j = (shi * 10 + ge) * sh;
						if (i < 1000 && i > 100 && j < 100 && j > 10) {
							// i小于1000大于100则符合条件
							int m = i / 100; // 百位数
							int n = i / 10; // 十位数
							int k = i % 10; // 个位数
							// 对2取余等于0且不等于0
							if (m % 2 == 0 && n % 2 == 0 && k % 2 == 0 && m != 0 && n != 0 && k != 0) {
								m = j / 10;// 十位数
								n = j % 10;// 个位数
								if (m % 2 == 0 && n % 2 == 0 && m != 0 && n != 0) {
									int x = i + j * 10;
									m = x / 100; // 百位数
									n = x / 10; // 十位数
									k = x % 10; // 个位数
									if (m % 2 == 0 && n % 2 == 0 && k % 2 == 0 && m != 0 && n != 0 && k != 0) {
										System.out.println(shi + "" + ge + " " + sh + "" + g);
									}
								}
							}
						}
					}
				}
			}
		}
		//双重for解决
		for (int i = 12;i < 100; i+=2) {
			for (int j = 21; j < 100; j+=2){
				if((i/10)%2!=0 &&(j/10)%2==0){
					int m = j / 10;// 十位数
					int n = j % 10;// 个位数
					int k = i * n;//i*个位数的值 三位数 且每位全是偶数
					
					if (k > 100 && k < 1000) {
						int x = k / 100; // 百位数
						int y = k / 10;// 十位数
						int z = k % 10; // 个位数
						if (x % 2 == 0 && y % 2 == 0 && z % 2 == 0 && x != 0 && y != 0 && z != 0) {
							k = i * m;//i*十位数的值 二位数 且每位全是偶数
							if (k > 10 && k < 100) {
								y = k / 10;// 十位数
								z = k % 10; // 个位数
								if (y % 2 == 0 && z % 2 == 0 && y != 0 && z != 0) {
									k = i * j;//两个数的积，三位数，且每位都是偶数
									if (k > 100 && k < 1000) {
										x = k / 100; // 百位数
										y = k / 10 % 10;// 十位数
										z = k % 10; // 个位数
										if (x % 2 == 0 && y % 2 == 0 && z % 2 == 0 && x != 0 && y != 0 && z != 0) {
											System.out.println(i + " " + j);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	// 第三题
	@Test
	public void test3() {
		// 创建Circle类的对象
		Circle circle = new Circle(10);
		circle.show();
		// 创建Cylinder类的对象
		Circle cylinder = new Cylinder(10, 5);
		cylinder.show();
	}

	// 第四题
	@Test
	public void test4() {

		// 创建学生类的对象，调用学生的显示信息的方法。
		Student student = new Student("zhangsan", 20, "nan", "10001");
		student.showInfo();
	}
}
