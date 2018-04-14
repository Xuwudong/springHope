package base;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		System.out.println(isJi(7));
		// int[] a = { 23, 43, 46, 34, 6653, 3443, 23, 66, 434, 2325, 53, 5, 65
		// };
		// quickSort(a, 0, a.length - 1);
		// System.out.println(Arrays.toString(a));
		// System.out.println(~(-10));
	}

	public static boolean isJi(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low > high)
			return;
		int i = low;
		int j = high;
		int key = arr[low];
		while (i < j) {
			while (i < j && arr[j] > key)
				j--;
			while (i < j && arr[i] <= key)
				i++;
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[low];
		arr[low] = arr[i];
		arr[i] = temp;
		quickSort(arr, low, i - 1);
		quickSort(arr, i + 1, high);
	}
}
