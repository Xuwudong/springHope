package base;

public class TestAbstarctClass {
	public static void main(String[] args) {
		new Foo() {
			int i = 2;

			@Override
			void f() {
				System.out.println(i);
			}

		}.f();
	}
}

abstract class Foo {
	int i = 4;

	protected Foo() {
		System.out.println(i);
	}

	abstract void f();
}
