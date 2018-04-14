package jianzhioffer.tree;
/***
 * ���������Ķ�����������任ΪԴ�������ľ���
 * �������ľ����壺Դ������ 
 *  	    8
 *   	   /  \
 *   	  6   10
 *  	 / \  / \
 *  	5  7 9 11
 *  	���������
 *  	    8
 *  	   /  \
 *   	  10   6
 *  	 / \  / \
 *  	11 9 7  5
 * @author APP
 *
 */
public class Mirror {
	public void mirror(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }
}
