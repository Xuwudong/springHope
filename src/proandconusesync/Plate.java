package proandconusesync;

public class Plate {
	int count;
	Fruit fruit;

	public void putApple(Apple apple) {
		synchronized (this) {
			//���������ѵcount��������ܳ��ְְ�����ͬʱ������Ȼ��ͬʱ��1ʹ��count����2�����¶���Ů������wait(),���������
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
			System.out.println("�ְַ���һ��ƻ��:  " + apple + "\t" + fruit.id + "\t" + count);
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
			System.out.println("�������һ������:  " + orange + "\t" + orange.id + "\t" + count);
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
				System.out.println("���ӳ���һ��ƻ��:  " + apple + "\t" + apple.id + "\t\t" + count);
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
				System.out.println("Ů������һ������:  " + orange + "\t" + orange.id + "\t\t" + count);
				this.notifyAll();
				return orange;
			} else
				return null;
		}
	}
}
