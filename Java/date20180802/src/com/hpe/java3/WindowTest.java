package com.hpe.java3;

//模拟卖票，三个窗口卖票100
/*
 * 线程安全的问题：重票、错票
 * 1.线程安全存在问题的原因？
 * 	在一个线程操作共享数据的过程中，在未执行完毕的情况下，另外的线程参与了进来，导致共享数据存在安全问题
 * 2.如何解决线程的安全问题？
 * 	必须让一个数据操作共享数据完毕之后，其他线程才有机会参与共享数据的操作
 * 3.Java如何实现线程安全？线程同步机制
 * 如何实现：两种方式
 * 	方式一：使用同步代码块
 * 		synchronized(同步监视器){
 * 			//需要被同步的代码（即为操作共享数据的代码）
 * 		}
 *	//共享数据：多个线程共同操作的同一数据（变量）
 *  //同步监视器：就是一个对象，哪个线程获此同步监视器，谁就执行大括号内的代码，在此期间，别的线程进不来（锁）
 * 	//所有线程必须使用同一把锁	
 * 	//注意：在实现的方式中，考虑同步问题，如果使用同步代码块的方式，可以使用this，但是如果使用使用继承的方式时，要慎用this
 *  方式二：
 * 
 */
class Window2 implements Runnable {

	Object obj = new Object();
	int ticket = 100;

	@Override
	public void run() {

		// 卖票(循环-->票数大于0)
		while (true) {
			synchronized(obj){
				if (ticket > 0) {
					// 卖票
					System.out.println(Thread.currentThread().getName() + "售票，票号：" + ticket);
					ticket--;// 票数减一
				} else
					break;
			}
		}
	}
	
	
}

public class WindowTest {

	public static void main(String[] args) {

		Window2 w = new Window2();

		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);

		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");

		t1.start();
		t2.start();
		t3.start();

	}

}
