package jianzhioffer.tree;

import java.util.ArrayList;

/***
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * @author APP
 *
 */
public class FindPath {
	public static void main(String[] args) {
		FindPath f = new FindPath();
		TreeNode root = new TreeNode(10);
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(12);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(7);
		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t1.right = t4;
		f.findPath(root, 22);
	}

	private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	private ArrayList<Integer> path = new ArrayList<>();

	/**
	 * dfs
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		if (root == null)
			return res;
		path.add(root.val);
		target -= root.val;
		if (target == 0 && root.left == null && root.right == null) {
			res.add(new ArrayList<Integer>(path));
		}
		findPath(root.left, target);
		findPath(root.right, target);
		path.remove(path.size() - 1);
		return res;
	}
}
