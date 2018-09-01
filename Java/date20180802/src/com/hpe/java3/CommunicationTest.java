package com.hpe.java3;

//线程通信相关的方法:都得在同步代码块或者同步方法中使用
//wait()，一旦一个线程调用了wait,释放锁
//notify()/notifyAll(),唤醒wait的一个/所有的线程

//打印1-100之间的数使用两个线程来打印，实现交替打印
//多线程：是
//共享数据：num
//线程安全
class PrintNum implements Runnable {

	int num = 1;

	@Override
	public void run() {

		while (true) {

			synchronized (this) {
				
				notify();
				
				if (num <= 100) {
					// 打印num,num++
					System.out.println(Thread.currentThread().getName() + "" + num);
					num++;
				} else {
					break;
				}
				
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}
	}

}

public class CommunicationTest {

	public static void main(String[] args) {

		PrintNum p = new PrintNum();
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		
		t1.setName("张三");
		t2.setName("李四");
		
		t1.start();
		t2.start();
		
	}
}
