package writtenexam;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountTo_75 {

	public static void main(String[] args) {
		final Box box = new Box();

		new Thread(new Runnable() { // 线程1
			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					box.main_1();
				}
			}
		}, "Thread-1").start();
		new Thread(new Runnable() { // 线程2
			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					box.main_2();
				}
			}
		}, "Thread-2").start();
		new Thread(new Runnable() { // 线程3
			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					box.main_3();
				}
			}
		}, "Thread-3").start();
	}

	static class Box {
		Lock lock = new ReentrantLock();
		Condition condition_1 = lock.newCondition();
		Condition condition_2 = lock.newCondition();
		Condition condition_3 = lock.newCondition();
		private int flag = 1;
		public static int count = 0; // 用于计数的变量

		public void main_1() {
			lock.lock();
			try {
				while (flag != 1) {
					try {
						condition_1.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 0; j < 5; j++) {
					count++;
					System.out.println(Thread.currentThread().getName() + " " + count);
				}
				flag = 2;
				condition_2.signal();
			} finally {
				lock.unlock();
			}
		}

		public void main_2() {
			lock.lock();
			try {
				while (flag != 2) {
					try {
						condition_2.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 0; j < 5; j++) {
					count++;
					System.out.println(Thread.currentThread().getName() + " " + count);
				}
				flag = 3;
				condition_3.signal();
			} finally {
				lock.unlock();
			}
		}

		public void main_3() {
			lock.lock();
			try {
				while (flag != 3) {
					try {
						condition_3.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 0; j < 5; j++) {
					count++;
					System.out.println(Thread.currentThread().getName() + " " + count);
				}
				flag = 1;
				condition_1.signal();
			} finally {
				lock.unlock();
			}
		}
	}

}