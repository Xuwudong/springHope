package writtenexam;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreadPrintUseLock {
	public static int num = 1;
	public static ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		Printor p1 = new Printor();
		Printor p2 = new Printor();
		Printor p3 = new Printor();
		p1.next = p2;
		p2.next = p3;
		p3.next = p1;
		new Thread(p1).start();
		new Thread(p2).start();
		Thread t = new Thread(p3);
	}

	static class Printor implements Runnable {
		Printor next;
		Condition con = lock.newCondition();

		public Printor() {
		}

		public void run() {
			while (num <= 60) {
				lock.lock();
				System.out.print(Thread.currentThread().getName() + "\t");
				for (int i = 0; i < 5; i++) {
					System.out.print(num++ + "\t");
				}
				System.out.println();
				next.con.signal();
				try {
					this.con.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("end");
		}
	}
	
	

}
