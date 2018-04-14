package proandconusesync;

public class Plate {
	int count;
	Fruit fruit;

	public void putApple(Apple apple) {
		synchronized (this) {
			//这里必须轮训count，否则可能出现爸爸妈妈同时被唤醒然后同时加1使得count等于2，导致儿子女儿必须wait(),最后导致死锁
			while (true) {
				if (count != 0)
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				else
					break;
			}
			fruit = apple;
			count++;
			System.out.println("爸爸放了一个苹果:  " + apple + "\t" + fruit.id + "\t" + count);
			this.notifyAll();
		}
	}

	public void putOrange(Orange orange) {
		synchronized (this) {
			while (true) {
				if (count != 0)
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				else
					break;
			}
			fruit = orange;
			count++;
			System.out.println("妈妈放了一个橘子:  " + orange + "\t" + orange.id + "\t" + count);
			this.notifyAll();
		}
	}

	public Apple getApple() {
		synchronized (this) {
			while (true) {
				if (count != 1)
					try {
						this.wait();
					} catch (InterruptedException e) {
					}
				else
					break;
			}
			if (this.fruit instanceof Apple) {
				count--;
				Apple apple = (Apple) this.fruit;
				this.fruit = null;
				System.out.println("儿子吃了一个苹果:  " + apple + "\t" + apple.id + "\t\t" + count);
				this.notifyAll();
				return apple;
			} else
				return null;
		}
	}

	public Orange getOrange() {
		synchronized (this) {
			while (true) {
				if (count != 1)
					try {
						this.wait();
					} catch (InterruptedException e) {
					}
				else
					break;
			}
			if (fruit instanceof Orange) {
				count--;
				Orange orange = (Orange) this.fruit;
				this.fruit = null;
				System.out.println("女儿吃了一个橘子:  " + orange + "\t" + orange.id + "\t\t" + count);
				this.notifyAll();
				return orange;
			} else
				return null;
		}
	}
}
