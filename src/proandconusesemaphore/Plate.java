package proandconusesemaphore;

import java.util.concurrent.Semaphore;

import proandconusesync.Apple;
import proandconusesync.Fruit;
import proandconusesync.Orange;

public class Plate {
	Semaphore notFull = new Semaphore(1);
	Semaphore notEmpty = new Semaphore(0);
	// Semaphore mutex = new Semaphore(1);
	Fruit fruit;

	public void putApple(Apple apple) {
		try {
			notFull.acquire();
			this.fruit = apple;
			System.out.println("爸爸放了一个苹果:  " + apple + "  " + apple.id);
			notEmpty.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void putOrange(Orange orange) {
		try {
			notFull.acquire();
			this.fruit = orange;
			System.out.println("妈妈放了一个橘子:  " + orange + "  " + orange.id);
			notEmpty.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Apple getApple() {
		try {
			notEmpty.acquire();
			if (this.fruit instanceof Apple) {
				Apple apple = (Apple) this.fruit;
				System.out.println("儿子吃了一个苹果:  " + apple + "  " + apple.id);
				this.fruit = null;
				notFull.release();
				return apple;
			} else {
				notEmpty.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Orange getOrange() {
		try {
			notEmpty.acquire();
			if (this.fruit instanceof Orange) {
				Orange orange = (Orange) this.fruit;
				this.fruit = null;
				System.out.println("女儿吃了一个橘子:  " + orange + "  " + orange.id);
				notFull.release();
				return orange;
			}else{
				notEmpty.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
