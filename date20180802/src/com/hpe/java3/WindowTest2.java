package com.hpe.java3;

//模拟卖票，三个窗口卖票100

class Window3 extends Thread{
	
	static int ticket = 100;
	static Object obj = new Object();
	@Override
	public void run() {

		//卖票(循环-->票数大于0)
		while(true){
			
			synchronized (obj ) {
				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + "售票，票号：" + ticket);
					ticket--;//票数减一

				} else
					break;
			}
		}
	}
}

public class WindowTest2 {

	public static void main(String[] args) {

		Window3 w1 = new Window3();
		Window3 w2 = new Window3();
		Window3 w3 = new Window3();
		
		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");
		
		w1.start();
		w2.start();
		w3.start();
		
	}

}
