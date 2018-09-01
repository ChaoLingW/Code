package com.hpe.exec;

/*
 * 创建两个子线程，让其中一个输出1-100之间的偶数，另一个输出1-100之间的奇数
 */
class PrintOdd implements Runnable{

	@Override
	public void run() {

		//打印1-100奇数
		for(int i = 1; i <= 100; i+=2)
			System.out.println(Thread.currentThread().getName() + ":" + i);
	}
	
}

class PrintEven implements Runnable{

	@Override
	public void run() {

		//打印1-100偶数
		for(int i = 2; i <= 100; i+=2)
			System.out.println(Thread.currentThread().getName() + ":" + i);
	}
	
}

public class PrintNum {
	
	public static void main(String[] args) {

		PrintEven even = new PrintEven();
		PrintOdd odd = new PrintOdd();
		
		Thread t1= new Thread(even);
		Thread t2= new Thread(odd);
		
		t1.start();
		t2.start();
	
	}

}
