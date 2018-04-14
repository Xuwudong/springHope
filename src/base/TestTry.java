package base;

public class TestTry {
	public static void main(String[] args) {
		try {
			System.out.println(testReturn());
			System.exit(0);
		} finally {
			System.out.println("do finally");
		}
	}

	@SuppressWarnings("finally")
	private static int testReturn() {
		try {
			return 1;
		} finally {
			return 2;
		}
	}
}
