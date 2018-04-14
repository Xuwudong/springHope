package base;

import java.util.Scanner;
import java.util.Stack;

/***
 * ½øÖÆ×ª»»
 * 
 * @author APP
 *
 */
public class DecimalConversion {

	private static int[] a;
	private static int as[];
	private int[] a1;
	private int a2[];
	// private final int[] a3;
	// private static final int[] a4;

	// private int []a5 [3];
	// private int [3] a6 [];
	// private int a7 [][7];
	// private [] int a8;
	// private int [] [7] a9;
	private int[][] a10 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	public static void main(String[] args) {
		System.out.println(count_one(6));
		// System.out.println(tenToN(99,1000));
		// for(int i = 2;i<1000;i++){
		// if((add_n(tenToN(99, i), tenToN(68, i), i) == tenToN(256, i))){
		// System.out.println(i);
		// };
		// }
		// Scanner sc = new Scanner(System.in);
		// while (sc.hasNextInt()) {
		// int n = sc.nextInt();
		// System.out.println(add_n(tenToN(99, n), tenToN(68, n), n) ==
		// tenToN(256, n));
		// }
	}

	public static Integer add_n(int a, int b, int n) {
		Stack<Integer> sa = new Stack<>();
		Stack<Integer> sb = new Stack<>();
		char[] ca = String.valueOf(a).toCharArray();
		char[] cb = String.valueOf(b).toCharArray();
		for (char c : ca) {
			sa.push(c - 48);
		}
		for (char c : cb) {
			sb.push(c - 48);
		}
		int carry = 0;
		Stack<Integer> sc = new Stack<>();
		while (!sa.isEmpty() && !sb.isEmpty()) {
			int i = sa.pop();
			int j = sb.pop();
			int sum = i + j + carry;
			if (sum >= n) {
				sum = sum % n;
				carry = 1;
			}
			sc.push(sum);
		}
		while (!sa.isEmpty()) {
			int i = sa.pop();
			int sum = i + carry;
			if (sum >= n) {
				sum = sum % n;
				carry = 1;
			}
			sc.push(sum);
		}
		while (!sb.isEmpty()) {
			int i = sb.pop();
			int sum = i + carry;
			if (sum >= n) {
				sum = sum % n;
				carry = 1;
			}
			sc.push(sum);
		}
		if (carry != 0)
			sc.push(carry);
		StringBuilder str = new StringBuilder();
		while (!sc.isEmpty()) {
			str.append(sc.pop());
		}
		return Integer.valueOf(str.toString());
	}

	public static Integer tenToN(int num, int n) {
		Stack<Integer> s = new Stack<>();
		while (num >= n) {
			s.push(num % n);
			num = num / n;
		}
		s.push(num);
		StringBuilder sb = new StringBuilder();
		while (!s.isEmpty()) {
			sb.append(s.pop());
		}
		return Integer.valueOf(sb.toString());
	}

	public static int count_one(int n) {
		int count = 0;
		while (n > 0) {
			n = n & n - 1;
			count++;
		}
		return count;
	}

	public String replaceSpace(StringBuffer str) {
		int spaceNum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				spaceNum++;
		}
		int indexOld = str.length() - 1;
		int newLength = str.length() + 2 * spaceNum;
		int indexNew = newLength - 1;
		str.setLength(newLength);
		for (; indexOld >= 0; indexOld--) {
			if (str.charAt(indexOld) == ' ') {
				str.setCharAt(indexNew--, '0');
				str.setCharAt(indexNew--, '2');
				str.setCharAt(indexNew--, '%');
			} else {
				str.setCharAt(indexNew--, str.charAt(indexOld));
			}
		}
		return str.toString();
	}
}
