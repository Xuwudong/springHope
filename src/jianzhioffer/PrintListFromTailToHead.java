package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class PrintListFromTailToHead {

	public static void main(String[] args) {
		ListNode head = new ListNode(21);
		ListNode two = new ListNode(12);
		ListNode three = new ListNode(1);
		head.next = two;
		two.next = three;
		ArrayList<Integer> list = printListFromTailToHead2(head);
		for (int i : list)
			System.out.println(i);
	}

	private static ArrayList<Integer> list = new ArrayList<>();

	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		if (listNode != null) {
			printListFromTailToHead2(listNode.next);
			list.add(listNode.val);
		}
		return list;
	}

	/**
	 * Ó²½â
	 * 
	 * @param listNode
	 * @return
	 */
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		int count = 0;
		ListNode head = listNode;
		while (listNode != null) {
			count++;
			listNode = listNode.next;
		}
		int[] a = new int[count];
		while (head != null) {
			a[--count] = head.val;
			head = head.next;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : a) {
			list.add(i);
		}
		return list;
	}
}
