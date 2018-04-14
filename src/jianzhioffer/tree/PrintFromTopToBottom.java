package jianzhioffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/***
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * 
 * @author APP
 *
 */
public class PrintFromTopToBottom {
	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null)
			bfs(root, queue, res);
		return res;
	}

	private void bfs(TreeNode root, Queue<TreeNode> queue, ArrayList<Integer> res) {
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			res.add(temp.val);
			if (temp.left != null)
				queue.offer(temp.left);
			if (temp.right != null)
				queue.offer(temp.right);
		}
	}
}
