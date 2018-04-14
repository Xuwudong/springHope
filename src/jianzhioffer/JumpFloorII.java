package jianzhioffer;

public class JumpFloorII {
	public static int[] a = new int[100];

	public static int jumpFloorII(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (a[n] == 0) {
			for (int i = 1; i < n; i++) {
				a[n] += jumpFloorII(i);
			}
			a[n]++;
		}
		return a[n];
	}

	public static void main(String[] args) {
		System.out.println(jumpFloorII(4));
	}
}
