package base;

public class Base {
	private String baseName = "base";

	public Base() {
		callName();
	}

	public void callName() {
		System.out.println(baseName);
	}

	public static void main(String[] args) {
		Base b = new Sub();
	}
}

class Sub extends Base {
	private String baseName = "sub";

	public void callName() {
		System.out.println(baseName);
	}
}