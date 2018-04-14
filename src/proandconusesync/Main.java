package proandconusesync;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	public static Plate2 plate = new Plate2();
	public static AtomicInteger id = new AtomicInteger(0);

	public static void main(String[] args) {
		// �ְ�
		new Thread(new Runnable() {

			public Apple product() {
				return new Apple(id.getAndIncrement());
			}

			public void run() {
				while (true) {
					Apple apple = product();
					synchronized (plate) {
						while (true) {
							if (plate.count != 0) {
								try {
									plate.wait();
								} catch (InterruptedException e) {
								}
							} else
								break;
						}
						plate.fruits.add(apple);
						plate.count++;
						System.out.println("�ְַ���һ��ƻ��:  " + apple + "\t" + apple.id);
						plate.notifyAll();
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
			}
		}).start();

		// ����
		new Thread(new Runnable() {

			public Orange product() {
				return new Orange(id.getAndIncrement());
			}

			public void run() {
				while (true) {
					Orange orange = product();
					synchronized (plate) {
						while (true) {
							if (plate.count != 0) {
								try {
									plate.wait();
								} catch (InterruptedException e) {
								}
							} else
								break;
						}
						plate.fruits.add(orange);
						plate.count++;
						System.out.println("�������һ������:  " + orange + "\t" + orange.id);
						plate.notifyAll();
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					synchronized (plate) {
						while (true) {
							if (plate.count != 1)
								try {
									plate.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							else
								break;
						}
						if (plate.fruits.get(0) instanceof Apple) {
							plate.count--;
							Apple a = (Apple) plate.fruits.get(0);
							plate.fruits.remove(0);
							System.out.println("���ӳ���һ��ƻ��:  " + a + "\t" + a.id);
							plate.notifyAll();
						}
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					synchronized (plate) {
						while (true) {
							if (plate.count != 1)
								try {
									plate.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							else
								break;
						}
						if (plate.fruits.get(0) instanceof Orange) {
							plate.count--;
							Orange a = (Orange) plate.fruits.get(0);
							plate.fruits.remove(0);
							System.out.println("Ů������һ������:  " + a + "\t" + a.id);
							plate.notifyAll();
						}
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
