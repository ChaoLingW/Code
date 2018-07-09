package com.hpe.java;

/**
 * 
 * @author chaoling
 * @date 2018年7月9日上午11:15:32
 * @Description
 */
public class ForTest {

	public static void main(String[] args) {

		// test1();
		// test2();
		// test3();
		// test4();
		// test5;
		test6();

	}

	// 打印10遍我爱你
	public static void test1() {

		int count = 0;

		while (count < 10) {

			System.out.println("我爱你");

			count++;

		}

	}

	// 打印10遍我爱你-for
	public static void test2() {

		for (int count = 0; count < 10; count++) {

			System.out.println("我爱你");

		}

	}

	// 死循环
	public static void test3() {

		// 去掉条件表达式或者迭代表达式
		for (int count = 0; count < 10; count++) {

			System.out.println("我爱你");

		}
	}

	// 找出100-999之间的水仙花数
	public static void test4() {

		// 定义三个变量，分别表示个位数，十位数，百位数
		int a, b, c;

		System.out.println("100-999之间的水仙花数");

		for (int i = 100; i <= 999; i++) {

			c = i / 100;
			b = i % 100 / 10;// b = i / 10 % 10;
			a = i % 10;

			if (i == a * a * a + b * b * b + c * c * c)
				if (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == i)
					System.out.print(i + " ");

		}

	}

	public static void test5() {

		for (int count = 0; count < 10; count++) {

			System.out.println("我爱你");

		}

	}

	// 打印水仙花数100-999之间
	public static void test6() {

		System.out.println("水仙花数100-999之间");

		for (int ge = 0; ge < 10; ge++) {
			for (int shi = 0; shi < 10; shi++) {
				for (int bai = 1; bai < 10; bai++) {
					
					int sum = ge + shi * 10 + bai * 100;

					if (sum == Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3))
						System.out.print(ge + shi * 10 + bai * 100 + " ");

				}
			}

		}

	}

}
