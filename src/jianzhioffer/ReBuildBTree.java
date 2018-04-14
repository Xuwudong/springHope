package jianzhioffer;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class ReBuildBTree {
	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		reConstructBinaryTree2(pre, in);
	}

	public static TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
		return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn,
			int endIn) {
		if (startPre > endPre || startIn > endIn)
			return null;
		TreeNode node = new TreeNode(pre[startPre]);
		for (int i = startIn; i <= endIn; i++) {
			if (in[i] == pre[startIn]) {
				node.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
				node.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
				break;
			}
		}
		return node;
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode head = new TreeNode(pre[0]);
		int cur = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == pre[0]) {
				cur = i;
				break;
			}
		}
		if (cur != 0) {
			int[] left_pre = new int[cur];
			int[] left_in = new int[cur];
			for (int i = 0; i < left_pre.length; i++) {
				left_pre[i] = pre[i + 1];
				left_in[i] = in[i];
			}
			head.left = reConstructBinaryTree(left_pre, left_in);
		}
		if (cur != in.length - 1) {
			int[] right_pre = new int[in.length - 1 - cur];
			int[] right_in = new int[in.length - 1 - cur];
			for (int i = 0; i < right_pre.length; i++) {
				right_pre[i] = pre[cur + 1 + i];
				right_in[i] = in[cur + 1 + i];
			}
			head.right = reConstructBinaryTree(right_pre, right_in);
		}
		return head;
	}
}
