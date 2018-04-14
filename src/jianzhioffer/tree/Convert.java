package jianzhioffer.tree;

import java.util.Stack;

/***
 * 输入一棵二叉搜索树， 将该二叉搜索树转换成一个排序的双向链表。 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author APP
 *
 */
public class Convert {
	public static void main(String[] args) {
		Convert c = new Convert();
		TreeNode root = new TreeNode(10);
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(12);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(7);
		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t1.right = t4;
		TreeNode res = c.convert2(root);
		while (res.right != null) {
			System.out.print(res.val + "  ");
			res = res.right;
		}
		System.out.print(res.val);
		System.out.println();
		while (res != null) {
			System.out.print(res.val + "  ");
			res = res.left;
		}

	}

	private TreeNode res;
	private TreeNode pre;

	public TreeNode convert(TreeNode pRootOfTree) {
		inOrderTra(pRootOfTree);
		return res;
	}
	/**
	 * 非递归实现
	 * @param root
	 * @return
	 */
	public TreeNode convert2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		TreeNode p = root;
		TreeNode head = null;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			if (head == null) {
				pre = p;
				head = p;
			} else {
				pre.right = p;
				p.left = pre;
				pre = p;
			}
			p = p.right;
		}
		return head;
	}

	/**
	 * 递归实现
	 * @param cur
	 */
	void inOrderTra(TreeNode cur) {
		if (cur == null)
			return;
		inOrderTra(cur.left);
		if (res == null) {
			pre = cur;
			res = cur;
		} else {
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		inOrderTra(cur.right);
	}
}
