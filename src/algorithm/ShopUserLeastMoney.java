package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/***
 * 
 * @author APP
 *���۰�
 */
class Plan {
	int price;
	int[] shoplist;
}

public class ShopUserLeastMoney {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			int k = 1;
			while (t > 0) {
				int n = sc.nextInt();
				int[] shopArr = new int[n];
				// ������Ʒ
				boolean[] hasShop = new boolean[n];
				for (int i = 0; i < n; i++) {
					shopArr[i] = sc.nextInt();
				}
				int N = sc.nextInt();
				Plan[] planMap = new Plan[N];
				for (int j = 0; j < N; j++) {
					Plan plan = new Plan();
					plan.price = sc.nextInt();
					int M = sc.nextInt();
					plan.shoplist = new int[M];
					for (int i = 0; i < M; i++) {
						plan.shoplist[i] = sc.nextInt();
					}
					planMap[j] = plan;
				}
				System.out.println("#" + k++ + " " + getMinPrice(shopArr, hasShop, planMap));
				t--;
				clear();
			}
		}
	}

	private static void clear() {
		minPrice = Integer.MAX_VALUE;
		sumPrice = 0;
	}

	private static int minPrice = Integer.MAX_VALUE;
	private static int sumPrice = 0;

	private static int getMinPrice(int[] shopArr, boolean[] hasShop, Plan[] planList) {
		// ��ÿ����㿪ʼ����
		for (int i = 0; i < planList.length; i++) {
			boolean[] hasPlan = new boolean[planList.length];
			Plan start = planList[i];
			getMinPrice(shopArr, hasShop, planList, start, i, hasPlan);
			clear(hasShop);
		}
		if (minPrice != Integer.MAX_VALUE)
			return minPrice;
		return -1;
	}

	private static Stack<Integer> visited = new Stack<>();

	private static void clear(boolean[] hasShop) {
		for (int i = 0; i < hasShop.length; i++)
			hasShop[i] = false;
		sumPrice = 0;
	}

	/**
	 * DFS-- ��ȡ�ӵ�ǰ�����㿪ʼ����С�۸�
	 * 
	 * @param shopArr ������Ʒ�б�
	 * @param hasShop ��ǰ�ѹ���Ʒ�б�
	 * @param planList  ���۰��б�
	 * @param start   ��ǰ���۰�
	 * @param i   ��ǰ���۰������б�����
	 * @param hasPlan ���۰��Ƿ��ѹ��б�
	 */
	private static void getMinPrice(int[] shopArr, boolean[] hasShop, Plan[] planList, Plan start, int i,
			boolean[] hasPlan) {
		visited.push(i);
		// �Ƿ����
		if (traversePlan(shopArr, hasShop, start, i, planList, hasPlan))
			return;

		List<Plan> nexts = getNextPlans(planList, i + 1);
		for (int j = 0; j < nexts.size(); j++) {
			getMinPrice(shopArr, hasShop, planList, nexts.get(j), i + j + 1, hasPlan);
		}
		visited.pop();
		recalculatePrice(i, hasPlan, planList);
		// ����pop���ļƻ���hasShop��Ӱ�죻
		reHasShop(shopArr, hasShop, planList);
	}

	private static void recalculatePrice(int index, boolean[] hasPlan, Plan[] planlist) {
		if (hasPlan[index]) {
			hasPlan[index] = false;
			Plan temp = planlist[index];
			int price = temp.price;
			sumPrice -= price;
		}
	}

	private static void reHasShop(int[] shopArr, boolean[] hasShop, Plan[] planlist) {
		for (int i = 0; i < hasShop.length; i++)
			hasShop[i] = false;
		for (int i = 0; i < visited.size(); i++) {
			Plan temp = planlist[visited.elementAt(i)];
			int[] shoplist = temp.shoplist;
			for (int j = 0; j < shoplist.length; j++) {
				for (int k = 0; k < shopArr.length; k++) {
					if (shopArr[k] == shoplist[j])
						hasShop[k] = true;
				}
			}
		}
	}

	private static List<Plan> getNextPlans(Plan[] planMap, int n) {
		List<Plan> list = new ArrayList<>();
		for (; n < planMap.length; n++) {
			if (!visited.contains(n))
				list.add(planMap[n]);
		}
		return list;
	}

	// ����ָ���ڵ�
	private static boolean traversePlan(int[] shopArr, boolean[] hasShop, Plan temp, int i, Plan[] planMap,
			boolean[] hasPlan) {
		if (sumPrice >= minPrice)
			return false;
		int[] key = temp.shoplist;
		int price = temp.price;
		return addShop(shopArr, hasShop, key, price, i, planMap, hasPlan);
	}

	private static boolean addShop(int[] shopArr, boolean[] hasShop, int[] key, int price, int k, Plan[] planMap,
			boolean[] hasPlan) {
		boolean hasShopInNood = false;
		for (int j = 0; j < key.length; j++)
			for (int i = 0; i < shopArr.length; i++)
				if (shopArr[i] == key[j] && !hasShop[i]) {
					hasShopInNood = true;
					hasShop[i] = true;
				}
		if (hasShopInNood) {
			hasPlan[k] = true;
			sumPrice += price;
		}
		// �����ݹ�
		if (!hasShoptoBuy(hasShop)) {
			minPrice = minPrice < sumPrice ? minPrice : sumPrice;
			sumPrice -= price;
			visited.pop();
			hasPlan[k] = false;
			reHasShop(shopArr, hasShop, planMap);
			return true;
		}
		return false;
	}

	private static boolean hasShoptoBuy(boolean[] hasShop) {
		for (int i = 0; i < hasShop.length; i++)
			if (!hasShop[i])
				return true;
		return false;
	}
}
