package proandconusesemaphore;

import java.util.concurrent.atomic.AtomicInteger;

import proandconusesync.Apple;
import proandconusesync.Orange;

public class Main {
	public static Plate plate = new Plate();
	public static AtomicInteger id = new AtomicInteger(0);

	public static void main(String[] args) {

		new Thread(new Runnable() {

			public void run() {
				while (true) {
					Apple apple = new Apple(id.getAndIncrement());
					plate.putApple(apple);
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
					Orange orange = new Orange(id.getAndIncrement());
					plate.putOrange(orange);
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
					plate.getApple();
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
					plate.getOrange();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
			}
		}).start();
	}
}
