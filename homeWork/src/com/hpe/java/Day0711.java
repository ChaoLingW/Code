package com.hpe.java;

import java.util.Scanner;

import org.junit.Test;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * 
 * @author chaoling
 * @date 2018年7月11日下午2:11:03
 * @Description
 */
public class Day0711 {

	@Test
	public void decompose() {

		// 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入一个正整数");

		int num = sc.nextInt();

		int i = 2;

		while (true) {

			if (num % i == 0) {

				if (num != i)

					System.out.print(i + "*");

				else {

					System.out.print(i);

					break;
				}

				num = num / i;

			} else

				i++;

		}

	}

	@Test
	public void test2() {

		// 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
		// 例如2+22+222+2222+22222(此时共有5个数相加)
		// 几个数相加有键盘控制。

		Scanner sc = new Scanner(System.in);

		System.out.println("请输入一个正整数");

		int a = sc.nextInt();

		System.out.println("请输入次数");

		int num = sc.nextInt();

		int sum = 0;
		int aa = a;
		int count = 0;

		while (count < num) {

			sum += a;

			if (count < num - 1)
				System.out.print(a + "+");
			else
				System.out.print(a);

			// 不能师a*10+a，a的值在变化
			a = a * 10 + aa;
			count++;

		}

		System.out.println("=" + sum);

	}

	@Test
	public void test3() {

		// 读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的*。
		int[] arr = new int[7];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 7; i++) {

			System.out.println("请输入第" + (i + 1) + "个数");

			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i]; j++) {

				System.out.print("*");

			}
			System.out.println();
		}

	}

	@Test
	public void test4() {

		/*
		 * 一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。 例如6=1＋2＋3.编程 找出1000以内的所有完数
		 */

		for (int i = 1; i < 1000; i++) {

			int sum = 0;

			System.out.println("1000以内的完数为：");

			for (int j = 1; j < i; j++) {

				if (i % j == 0)
					sum += j;

			}

			if (sum == i)
				System.out.print(sum + " ");

		}

	}

	@Test
	public void test5() {

		// 有1、2、3、4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
		int count = 0;

		for (int bai = 1; bai <= 4; bai++) {

			for (int shi = 1; shi <= 4; shi++) {

				for (int ge = 1; ge <= 4; ge++) {

					int sum = bai * 100 + shi * 10 + ge;

					if (bai != shi && bai != ge && shi != ge) {

						count++;
						System.out.print(sum + " ");

					}

				}

			}

			System.out.println();

		}

		System.out.println("共有" + count + "个");

	}

	@Test
	public void test6() {
		/*	
			   *   
			  ***   
			 *****   
			*******   
			 *****   
			  ***   
			   *   
		
			*/
		int num = 7;
		int half = num / 2;
		
		for (int i = 0; i < num; i++) {

			if (i < half) {
				for (int j = 0; j < half - i; j++)
					System.out.print(" ");

				for (int j = 0; j < (i + 1) * 2 - 1; j++)
					System.out.print("*");
			} else if (i == half) {
				for(int j = 0; j<num;j++)
					System.out.print("*");

			} else {
				for (int j = 0; j < i - half; j++)
					System.out.print(" ");

				for (int j = 0; j < (num -i) * 2 - 1; j++)
					System.out.print("*");

			}
			
			System.out.println();

		}

	}

	@Test
	public void test7() {

		/*
		 * 海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
		 * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，
		 * 问海滩上原来最少有多少个桃子？
		 */

		int monkey = 5;
		int peach = 1;

		for (int i = 0; i < monkey; i++) {

			peach = peach * 5 + 1;

		}

		System.out.println(peach);

	}

	@Test
	public void reverseOrder() {

		// 逆序
		int[] arr = { 1, 2, 3, 4, 5 };

		// 输出
		for (int begin = 0, end = arr.length - 1; begin < end; begin++, end--) {

			int temp;

			temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;

		}

		for (int i : arr)
			System.out.print(i + " ");

	}

	@Test
	public void select() {
		
		//输入一个整数，输出第4-7位
		int num = 1234567;
		int[] arr = new int[7];

		for (int i = 6; i >= 0; i--) {

			arr[i] = num % 10;

			num = num / 10;
		}

		for (int i = 3; i < 7; i++)

			System.out.print(arr[i] + " ");

	}

	@Test
	public void YangHuiTriangle() {

		// 输出杨辉三角，前10行
		int[][] arr = new int[10][];

		for (int i = 0; i < arr.length; i++) {

			// 必须在此进行动态初始化，否则会出现数组下标越界
			arr[i] = new int[i + 1];

			for (int j = 0; j <= i; j++) {

				if (j == 0 || j == i)
					arr[i][j] = 1;

				else
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];

			}

		}

		for (int x[] : arr) {

			// 填补空格
			for (int i = 9 - x.length; i >= 0; i--)
				System.out.print(" ");

			for (int i : x) {

				// 格式化输出增强美感
				System.out.printf("%3d", i);
				System.out.print(" ");

			}

			System.out.println();

		}

	}

	@Test
	public void exchange() {

		// 输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入数组长度");

		int size = sc.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < arr.length; i++) {

			System.out.printf("请输入数组中的第%d个元素\n", (i + 1));

			arr[i] = sc.nextInt();
		}

		System.out.print("输入的整数为：");

		for (int i : arr)
			System.out.print(i + " ");

		System.out.println();

		int maxIndex = 0;// 保存最大元素的索引
		int minIndex = 0;// 保存最小元素的索引

		for (int i = 1; i < arr.length; i++) {

			// 遍历数组，找到最小和最大元素的索引值并记录
			if (arr[i] < arr[minIndex])
				minIndex = i;
			
			if (arr[i] > arr[maxIndex])
				maxIndex = i;

		}

		// 交换
		int temp;
		
		// 最大值放在第一个
		temp = arr[0];
		arr[0] = arr[maxIndex];
		arr[maxIndex] = temp;
		
		// 最小值放在最后
		temp = arr[arr.length - 1];
		arr[arr.length - 1] = arr[minIndex];
		arr[minIndex] = temp;

		System.out.println("交换完成后");
		
		// 遍历
		for (int i : arr)
			System.out.print(i + " ");

	}

	@Test
	public void backShift() {
		
		//有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数   
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入整数的个数");

		int num = sc.nextInt();

		System.out.println("请输入后移的位数");

		int step = sc.nextInt();

		int[] arr = new int[num];
		int[] arr1 = new int[step];

		for (int i = 0; i < arr.length; i++) {

			System.out.printf("请输入第%d个整数\n", (i + 1));

			arr[i] = sc.nextInt();
		}

		System.out.print("输入的整数为：");

		for (int i : arr)
			System.out.print(i + " ");

		System.out.println();

		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			
			if (i < step) {
				
				arr1[i] = arr[i];
				arr[i] = arr[i + step];
				
			} else if (i < arr.length - step) {
				
				arr[i] = arr[i + step];
				
			} else {
				
				arr[i] = arr1[j];
				j++;
				
			}

		}

		for (int i : arr)
			System.out.print(i + " ");
	}

	@Test
	public void game() {

		//有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。   
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入人数");

		int num = sc.nextInt();

		Person[] arr = new Person[num];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = new Person(i + 1);

		}

		int count = 0;
		boolean flag = true;
		int i = 0;
		int three = 1;

		while (flag) {

			i = i % arr.length;

			if (arr[i].getFlag()) {

				if (three == 3) {
					arr[i].setFlag(false);
					three = 1;
				} else
					three++;
			}

			i++;
			count = 0;
			for (Person p : arr) {
				if (p.getFlag())
					count++;
			}

			if (count == 1)
				flag = false;

		}

		for (Person p : arr) {
			if (p.getFlag())
				System.out.println(p.getNo());
		}

	}

	public class Person {

		private boolean flag = true;
		private int no;

		public boolean getFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public Person(int no) {
			super();
			this.no = no;
		}

		public Person() {
			super();
		}

	}

	@Test
	public void encrypt() {
		/*
		 * 某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，
		 * 再将第一位和第四位交换，第二位和第三位交换。
		 */

		Scanner sc = new Scanner(System.in);

		System.out.println("请输入要加密的整数");

		int data = sc.nextInt();

		int[] arr = new int[4];

		for (int i = 3; i >= 0; i--) {

			arr[i] = data % 10;
			data = data / 10;
			arr[i] = (arr[i] * 5 % 10);

		}

		// 交换 逆序
		for (int begin = 0, end = arr.length - 1; begin < end; begin++, end--) {

			int temp;

			temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;

		}

		for (int i : arr)
			System.out.print(i + " ");

	}

}
