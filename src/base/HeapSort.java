package base;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] h = { 23, 43, 46, 34, 6653, 3443, 66, 434, 2325, 53, 5, 65 };
		heapSort(h);
		System.out.println(Arrays.toString(h));
	}

	public static void heapAdjust(int[] h, int sta, int end) {
		int temp = h[sta];
		for (int i = 2 * sta +1; i <= end; i *= 2) {
			if (i < end && h[i] < h[i + 1])
				i++;
			if (temp > h[i])
				break;
			h[sta] = h[i];
			sta = i;
		}
		h[sta] = temp;
	}

	public static void heapSort(int[] h) {
		for (int i = h.length / 2; i >= 0; i--) {
			heapAdjust(h, i, h.length-1);
		}

		for (int i = h.length - 1; i > 0; i--) {
			int temp = h[i];
			h[i] = h[0];
			h[0] = temp;
			heapAdjust(h, 0, i - 1);
		}
	}
}
