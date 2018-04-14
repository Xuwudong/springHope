package jianzhioffer.tree;

import java.util.Stack;

/***
 * ����һ�ö����������� ���ö���������ת����һ�������˫������ Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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
	 * �ǵݹ�ʵ��
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
	 * �ݹ�ʵ��
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
