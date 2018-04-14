package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * public static void main(String[] args) { Scanner sc = new
	 * Scanner(System.in); int n = sc.nextInt(); int[] arr = new int[n]; for
	 * (int i = 0; i < n; i++) { arr[i] = sc.nextInt(); }
	 * System.out.println(Arrays.toString(arr)); test(arr);
	 * System.out.println(Arrays.toString(arr)); }
	 */
	public static void main(String[] args) {
		int[] ARR = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		System.out.println(count(ARR, 12));
		// System.out.println(Integer.toBinaryString(-2));
		// System.out.println(Integer.toBinaryString(-2 >> 1));
		// System.out.println(-2 >> 1);
	}

	public static int count(int[] arr, int size) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			boolean isPrime = true;
			if (arr[i] == 1 || arr[i] == 0)
				continue;
			for (int j = 2; j <= (int) Math.sqrt(arr[i]); j++) {
				if (arr[i] % j == 0)
					isPrime = false;
			}
			if (isPrime)
				count++;
		}
		return count;
	}

	private static void test(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				for (int j = 0; j < i; j++) {
					if (arr[j] == 0) {
						int temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}
			}
		}
	}
}
