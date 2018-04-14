package writtenexam.progdesign;

public class Main {
	public static int count(ProgramType type, int time) {
		int count = 0;
		switch (type) {
		case ONE:
			count = Program.fix;
			break;
		case TWO:
			count = Program.base + Program.extraUnitPrice * time;
			break;
		case THREE:
			count = Program.unitPrice * time;
			break;
		default:
			throw new IllegalArgumentException("type:" + type.toString() + "¿‡–Õ¥ÌŒÛ");
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count(ProgramType.ONE, 10));
		System.out.println(count(ProgramType.TWO, 10));
		System.out.println(count(ProgramType.THREE, 10));
		System.out.println(count(ProgramType.FOUR, 10));
	}
}
