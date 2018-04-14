package writtenexam;

import java.util.HashSet;
import java.util.Set;

public class ThreeThreadsPrint {
	private static ThreeThreadsPrint o1 = new ThreeThreadsPrint();
	private static ThreeThreadsPrint o2 = new ThreeThreadsPrint();

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(-2 >> 1);
		test();
		/*
		 * new Thread(new Printer(0)).start(); new Thread(new
		 * Printer(1)).start(); new Thread(new Printer(2)).start();
		 */
	}

	// ÖØÈë
	public static synchronized void test2() {
		o1.test2();
		o2.test2();
	}

	public static void test() {
		Set<Short> set = new HashSet<>();
		for (Short i = 0; i < 1024; i++) {
			set.add(i);
			set.remove(i - 1);
		}
		System.out.println(set.size());
	}
}

class Printer implements Runnable {

	public static int num = 0;
	public static int end = 75;

	private int id;

	public Printer(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		synchronized (Printer.class) {
			while (num < end) {
				if (num / 5 % 3 == id) {
					System.out.println(id + "\t" + ++num);
					Printer.class.notifyAll();
				} else
					try {
						Printer.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
	}

}