package jianzhioffer.tree;

/***
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * @author APP
 *
 */
public class HasSubtree {
	public boolean hasSubTree(TreeNode tree1,TreeNode tree2){
		if(tree1 == null || tree2 == null) return false;
		return isSubTree(tree1,tree2) ||
				isSubTree(tree1.left,tree2) || 
				isSubTree(tree1.right,tree2);
	}

	private boolean isSubTree(TreeNode tree1, TreeNode tree2) {
		if(tree2 == null) return true;
		if(tree1 == null) return false;
		if(tree1.val == tree2.val){
			return isSubTree(tree1.left,tree2) && 
					isSubTree(tree1.right,tree2);
		}else
			return false;
	}
}
