package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***
 * 将一个正整数分解成质数之和
 * @author APP
 *
 */
public class IntegerToPrimes {
	private static int k = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		n = sc.nextInt();

		System.out.println(test(n));
	}

	public static ArrayList fenjie(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		while (n > 1) {
			for (int i = 2; i <= n; i = getNextPrime(i)) {
				if (n % i == 0) {
					list.add(i);
					n = n / i;
					break;
				}
			}
		}
		return list;
	}

	/**
	 * 获取i的下一个质数
	 * @param i
	 * @return
	 */
	private static int getNextPrime(int i) {
		while (true) {
			i++;
			if (isJi(i))
				return i;
		}
	}

	public static int test(int n) {
		ArrayList<Integer> list = (ArrayList) fenjie(n);
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 2)
				count++;
			else if (list.get(i) == 3)
				count += 2;
			else
				count += list.get(i) - 1;
		}
		return count;
	}

	public static boolean isJi(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	class Main2 {
		public void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int ans = 0, x;
			for (int i = 0; i < n; i++) {
				x = sc.nextInt();
			}
			System.out.println(ans);
		}

	}

}
