package com.hpe.java1;

//创建多线程的第二种方式：实现Runnable接口

//创建一个子线程：子线程中打印1-100之间的数

//继承Thread vs 实现Runnable接口
//Thread implements Runnable
//哪一种更好？实现Runnable
//1.实现Runnable接口的方式可以解决单继承的问题
//2.如果多个线程要操作同一份资源（数据），更适合实现Runnable的方式

//1.创建一个实现Runnable接口的类
class MyThread2 implements Runnable {

	// 2.重写run方法，run方法中的代码是子线程实现的功能
	@Override
	public void run() {

		for (int i = 1; i <= 100; i++)
			System.out.println(Thread.currentThread().getName() + ":" + i);
	
	}

}

public class RunnableTest {

	public static void main(String[] args) {

		// 3.创建Runnable接口实现类的对象
		MyThread2 m = new MyThread2();

		// 只有调用start才能启动子线程

		// 4.将此对象作为形参传递给Thread的构造器，创建Thread类的对象，此对象即是一个线程
		Thread t1 = new Thread(m);// 创建了一个子线程
		// 5.调用start方法，启动子线程
		t1.start();
		// 如何再创建一个子线程
		// 无需再创建Runnable接口实现类的对象，只需再创建一个Thread类
		Thread t2 = new Thread(m);
	
	}

}
