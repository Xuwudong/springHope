package jianzhioffer;

public class Bigger {
	public static void main(String args[]) {
		int a = -2147483647;
		int b = 2147483646;

		String[] strArray = { "a>=b", "a<b" };

		int i = (int) ((long) a - (long) b >>> 63);

		System.out.println(strArray[i]);
	}
}
