package jianzhioffer;

public class Fibonacci {
	public static void main(String[] args) {
		long sta = System.currentTimeMillis();
		System.out.println((long) fibonacci(1000000000000l));
		long end = System.currentTimeMillis();
		System.out.println("spent time:" + (end - sta));
	}

	public static long fibonacci(long n) {
		long f = 0;
		long g = 1;
		while ((long) n-- > 0) {
			g = g + f;
			f = g - f;
		}
		return f;
	}
}
