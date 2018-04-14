package jianzhioffer.tree;

/***
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
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
