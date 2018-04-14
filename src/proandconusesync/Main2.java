package proandconusesync;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Main2 {
	public static Plate plate = new Plate();
	public static AtomicInteger id = new AtomicInteger(0);

	public static void main(String[] args) {
		// °Ö°Ö
		new Thread(new Runnable() {

			public Apple product() {
				return new Apple(id.getAndIncrement());
			}

			public void run() {
				while (true) {
					Apple apple = product();
					plate.putApple(apple);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
			}
		}).start();

		// ‹Œ‹Œ
		new Thread(new Runnable() {

			public Orange product() {
				return new Orange(id.getAndIncrement());
			}

			public void run() {
				while (true) {
					Orange orange = product();
					plate.putOrange(orange);
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
					plate.getApple();
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
					plate.getOrange();
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
