package algorithm;

public class BTree<T extends Comparable<T>> {
	class BNodePreCur {
		BNode par;
		BNode next;
	}

	class BNode {
		T value;
		BNode left;
		BNode right;

		public BNode(T value) {
			this.value = value;
		}
	}

	BNode root;

	public void insert(T value) {
		BNode node = new BNode(value);
		if (node != null)
			insert(node);
	}

	private void insert(BNode node) {
		int cmp = 0;
		BNode pre = null;
		BNode p = this.root;
		while (p != null) {
			pre = p;
			cmp = node.value.compareTo(p.value);
			if (cmp < 0)
				p = p.left;
			else if (cmp > 0)
				p = p.right;
		}
		if (pre == null)
			this.root = node;
		else {
			cmp = node.value.compareTo(pre.value);
			if (cmp < 0)
				pre.left = node;
			else
				pre.right = node;
		}
	}

	public void delete(T value) {
		int cmp = 0;
		BNode par = null;
		BNode cur = root;
		while (cur != null) {
			cmp = value.compareTo(cur.value);
			if (cmp < 0) {
				par = cur;
				cur = cur.left;
			} else if (cmp > 0) {
				par = cur;
				cur = cur.right;
			} else
				break;
		}
		if (cur != null)
			delete(cur, par);
	}

	private void delete(BNode node, BNode par) {
		if (node.left == null)
			tranplant(par, node, node.right);
		else if (node.right == null)
			tranplant(par, node, node.left);
		else {
			BNodePreCur res = minimum(node, node.right);
			BNode pre2 = res.par;
			BNode next = res.next;
			if (node.right != next) {
				tranplant(pre2, next, next.right);
				;
				next.right = node.right;
			}
			tranplant(par, node, next);
			next.left = node.left;
		}

	}

	/**
	 * 将子树u替换成v
	 * 
	 * @param par
	 * @param u
	 * @param v
	 */
	private void tranplant(BNode par, BNode u, BNode v) {
		if (par == null)
			root = v;
		else if (par.left == u)
			par.left = v;
		else
			par.right = v;
	}

	/**
	 * 找到right最左边的结点及其父节点
	 * 
	 * @param pre
	 * @param right
	 * @return
	 */
	private BTree<T>.BNodePreCur minimum(BTree<T>.BNode pre, BTree<T>.BNode right) {
		BNodePreCur res = new BNodePreCur();
		while (right.left != null) {
			pre = right;
			right = right.left;
		}
		res.par = pre;
		res.next = right;
		return res;
	}

	public void inorder_tra() {
		inorder_tra(root);
		System.out.println();
	}

	private void inorder_tra(BNode node) {
		if (node == null)
			return;
		if (node.left != null)
			inorder_tra(node.left);
		System.out.print(node.value + "  ");
		if (node.right != null)
			inorder_tra(node.right);
	}
	
}
