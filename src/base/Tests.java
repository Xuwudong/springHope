package base;

public class Tests {
	private static void test(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			try {
				if (arr[i] % 2 == 0) {
					throw new NullPointerException();
				} else {
					System.out.print(i);
				}
			} catch (Exception e) {
				System.out.print("E");
			} finally {
				System.out.print("e");
			}
		}
	}

	public static void main(String[] args) {
		test(new int[] { 0, 1, 2, 3, 4, 5 });
	}

}
