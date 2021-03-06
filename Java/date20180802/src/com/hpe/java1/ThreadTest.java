package com.hpe.java1;

//实现多线称的方式：继承java.lang.Thread类
//创建一个子线程，在子线程中打印1-100之间所有的数，同时在子线程中也做同样的操作

//1.创建一个继承自Thread类的子类
class MyThread extends Thread{
	//2.重写run()方法，run方法中就是子线程要完成的功能
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++){
			System.out.println(Thread.currentThread().getName() + ":" +i);
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {

		//3.创建Thread子类的对象
		MyThread m1 = new MyThread();
		
		//4.启动子线程;调用run方法
		m1.start();//启动子线程，必须调用start();同一个线程只能start一次
		
		MyThread m2 = new MyThread();
		m2.start();
		
		for(int i = 1; i <= 100; i++){
			System.out.println(Thread.currentThread().getName() + ":" +i);
		
		}
	
	}

}
