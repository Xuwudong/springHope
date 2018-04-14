package base;

public class TestRewriteReLoad {
	public static void main(String[] args) {
		int[] arr = { 1, 4353, 65, 45, 3456 };
		// selectSort(arr);
		// bubbleSort(arr);
		insertSort(arr);
		print(arr);
	}

	private static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	public static void insertSort(int[] arr) {
		for (int p = 1; p < arr.length; p++) {
			int temp = arr[p];
			int j;
			for (j = p; j > 0 && arr[j - 1] > temp; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;
		}
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}

	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[i])
					swap(arr, i, j);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

class A {
	public A foo() {
		return this;
	}
}

class B extends A {
	public A foo() {
		return this;
	}
}

class C extends B {
	// public void foo(){};
	// public int foo(){
	// return 1;
	// }
	public A foo(B b) {
		return b;
	}
	// public A foo(){
	// return A;
	// }
}
