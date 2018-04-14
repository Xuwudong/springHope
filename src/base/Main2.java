package base;

/**
 * @author 16026
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		int y = 6;
		// yuesefu(3);
		System.out.println(yuesefu2(6, 2) + 1);
		// System.out.println(yuesefu(1, 3) + 1);
	}

	public static int yuesefu2(int n, int q) {
		int result = 0;
		if(n == 1 || q == 1)
			return 0;
		
		for (int i = 2; i <= n; i++) {
			result = (result + q) % i;
		}
		return result;
	}

	public static int yuesefu(int n, int q) {
		if (n == 1)
			return 0;
		else
			return (yuesefu(n - 1, q) + q) % n;
	}

	public static void yuesefu(int totalNum) {
		// 初始化人数
		List<Integer> start = new ArrayList<Integer>();
		for (int i = 1; i <= totalNum; i++) {
			start.add(i);
		}
		// 从第K个开始计数
		int k = 0;
		while (start.size() > 0) {
			k = k + 3;
			// 第m人的索引位置
			k = k % (start.size()) - 1;
			// 判断是否到队尾
			if (k < 0) {
				if (start.size() == 1)
					System.out.println(start.get(start.size() - 1));
				start.remove(start.size() - 1);
				k = 0;
			} else {
				if (start.size() == 1)
					System.out.println(start.get(k));
				start.remove(k);
			}
		}
	}

}