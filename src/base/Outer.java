package base;

public class Outer {
	private Outer(){}
	public static Outer getOuter(){
		return Inner.outer;
	}
	private static class Inner {
		public static Outer outer = new Outer();
	}
}
