package com.hpe.exec;
/*
 * 生产者Productor将产品交给店员（Clerk），而消费者（Customer）从店员处取走产品，
 * 店员一次只能持有固定数量的产品，如果生产者试图生产更多的产品，店员会叫生产者停一下
 * 如果店中有空位放产品了在通知生产者继续生产，如果店中没有了产品，店员会告诉消费者等一下
 * 如果有了产品，通知消费者取走产品
 */

//店员
class Clerk {

	int product;// 产品数量
	
	//
	public synchronized void addProduct(){
		//操作product
		if(product >=20)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		else{
			product++;
			System.out.println(Thread.currentThread().getName() + ":生产了第" + product + "件商品");
			notifyAll();
		}
	}
	
	public synchronized void consumeProduct(){
		//消费
		
		if(product<=0)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		else{
			System.out.println(Thread.currentThread().getName() + ":消费了第" + product + "件商品");
			product--;
			notifyAll();
		}
	}
}

// 生产者
class Productor implements Runnable {

	Clerk clerk;
	
	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}
	
	@Override
	public void run() {
		// 生产
	
		while (true) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.addProduct();
		}
	}

}

// 消费者
class Customer1 implements Runnable {

	Clerk clerk;
	public Customer1(Clerk clerk) {

		this.clerk = clerk;
	}
	@Override
	public void run() {
		// 消费
		while (true) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.consumeProduct();
		}
	}

}

public class ProductTest {

	public static void main(String[] args) {

		Clerk clerk = new Clerk();
		
		Productor p1 = new Productor(clerk);
		Productor p2 = new Productor(clerk);
		Productor p3 = new Productor(clerk);
		Customer1 c1 = new Customer1(clerk);
		Thread t1 = new Thread(p1);
		Thread t3 = new Thread(p1);
		Thread t4 = new Thread(p1);
		Thread t2 = new Thread(c1);
		
		t1.setName("生产者1");
		t3.setName("生产者2");
		t4.setName("生产者3");
		t2.setName("消费者1");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
