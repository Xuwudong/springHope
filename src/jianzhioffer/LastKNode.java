package jianzhioffer;

/***
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * @author APP
 *
 */
public class LastKNode {
	class ListNode<T extends Comparable<T>> {
		T val;
		ListNode<T> next;
	}

	public ListNode<Integer> FindKthToTail(ListNode<Integer> head, int k) {
		if (head == null || k == 0)
			return null;
		ListNode<Integer> pre = head, last = head;
		for (int i = 1; i < k; i++) {
			if (pre.next != null)
				pre = pre.next;
			else
				return null;
		}
		while (pre.next != null) {
			pre = pre.next;
			last = last.next;
		}
		return last;
	}
}
