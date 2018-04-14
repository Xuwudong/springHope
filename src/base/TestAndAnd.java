package base;

public class TestAndAnd {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			count = count++;
		}
		System.out.println(count);
	}
}
