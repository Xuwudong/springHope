package qiuzhao;

public class RBTree<T extends Comparable<T>> {
	private static final boolean red = true;
	private static final boolean black = false;

	private RBNode<T> root;

	class RBNode<T extends Comparable<T>> {

		private T key;
		private boolean color;
		private RBNode<T> left;
		private RBNode<T> right;
		private RBNode<T> parent;

		public RBNode(T key, boolean color, RBNode<T> left, RBNode<T> right, RBNode<T> parent) {
			super();
			this.key = key;
			this.color = color;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}

		public T getKey() {
			return key;
		}

		public void setKey(T key) {
			this.key = key;
		}

		public boolean isColor() {
			return color;
		}

		public void setColor(boolean color) {
			this.color = color;
		}

		public RBNode<T> getLeft() {
			return left;
		}

		public void setLeft(RBNode<T> left) {
			this.left = left;
		}

		public RBNode<T> getRight() {
			return right;
		}

		public void setRight(RBNode<T> right) {
			this.right = right;
		}

		public RBNode<T> getParent() {
			return parent;
		}

		public void setParent(RBNode<T> parent) {
			this.parent = parent;
		}

	}

	public void insert(T key) {
		RBNode<T> node = new RBNode<T>(key, black, null, null, null);

		// 如果新建结点失败，则返回。
		if (node != null)
			insert(node);
	}

	public void insert(RBNode<T> z) {
		int cmp = 0;
		RBNode<T> pre = null;
		RBNode<T> p = this.root;
		while (p != null) {
			pre = p;
			cmp = p.key.compareTo(z.key);
			if (cmp < 0)
				p = p.right;
			else
				p = p.left;
		}
		z.parent = pre;
		if (pre != null) {
			cmp = pre.key.compareTo(z.key);
			if (cmp < 0)
				pre.right = z;
			else
				pre.left = z;
		} else
			this.root = z;
		z.color = red;
		insertFixUp(z);
	}

	private void insertFixUp(RBTree<T>.RBNode<T> z) {

		/*
		 * 循环不变式： 1、结点z一定是红色的 2、如果z.p是根节点，则z.p是黑色的
		 * 3、如果有任何红黑性质被破坏，则最对只有一条被破坏，或是性质2，或是性质4，如果性质2被破坏，其原因为z是根节点且是红结点；
		 * 如果性质4被破坏，其原因为z和z.p都是红色的。
		 */

		while (z.parent != null && z.parent.color == red) {
			if (z.parent == z.parent.parent.left) {// z.p.p一定不为空
				RBNode<T> uncle = z.parent.parent.right;
				if (uncle != null && uncle.color == red) {// uncle是红色的
					z.parent.color = black;
					uncle.color = black;
					z.parent.parent.color = red;
					z = z.parent.parent;
				} else {
					if (z == z.parent.right) {// uncle是黑色的，并且z是右孩子
						z = z.parent;
						leftRotate(z);
					} else {// uncle是黑色的，并且z是左孩子
						z.parent.color = black;
						z.parent.parent.color = red;
						rightRotate(z.parent.parent);
					}
				}
			} else if (z.parent == z.parent.parent.right) {
				RBNode<T> uncle = z.parent.parent.left;
				if (uncle != null && uncle.color == red) {
					z.parent.color = black;
					uncle.color = black;
					z.parent.parent.color = red;
					z = z.parent.parent;
				} else {
					if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					} else {
						z.parent.color = black;
						z.parent.parent.color = red;
						leftRotate(z.parent.parent);
					}
				}
			}
		}
		this.root.color = black;
	}

	public void leftRotate(RBNode<T> x) {
		RBNode<T> y = x.right;
		x.right = y.left;
		if (y.left != null) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null)
			this.root = y;
		else {
			if (x == x.parent.left)
				x.parent.left = y;
			else
				x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}

	public void rightRotate(RBNode<T> y) {
		RBNode<T> x = y.left;
		y.left = x.right;
		if (x.right != null)
			x.right.parent = y;
		x.parent = y.parent;
		if (y.parent == null)
			this.root = x;
		if (y == y.parent.left)
			y.parent.left = x;
		else
			y.parent.right = x;
		y.parent = x;
		x.right = y;
	}

	private void transplant(RBNode<T> u, RBNode<T> v) {
		if (u.parent == null)
			root = v;
		else if (u == u.parent.left)
			u.parent.left = v;
		else
			u.parent.right = v;
		if (v != null)
			v.parent = u.parent;
	}

	public void delete(T key) {
		RBNode<T> node;

		if ((node = search(root, key)) != null)
			delete(node);
	}

	private RBNode<T> search(RBNode<T> x, T key) {
		if (x == null)
			return x;

		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return search(x.left, key);
		else if (cmp > 0)
			return search(x.right, key);
		else
			return x;
	}

	public void delete(RBNode<T> z) {
		RBNode<T> y = z;
		boolean y_o_color = y.color;
		RBNode<T> x = null;
		if (z.left == null) {
			x = z.right;
			transplant(z, z.right);
		} else if (z.right == null) {
			x = z.left;
			transplant(z, z.left);
		} else {
			y = minimum(z.right);
			y_o_color = y.color;
			x = y.right;
			// if (y.parent == z)
			// x.parent = y;
			// else {
			if (y.parent != z) {
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z, y);
			y.left = z.left;
			z.left.parent = y;
			y.color = z.color;
		}
		if (y_o_color == black)
			delete_fixup(x);
	}

	private void delete_fixup(RBTree<T>.RBNode<T> x) {
		// TODO Auto-generated method stub
		while (x != root && x != null && x.color == black) {
			if (x.parent != null && x == x.parent.left) {
				RBNode<T> bro = x.parent.right;
				if (bro != null && bro.color == red) {// bro为红色
					bro.color = black;
					x.parent.color = red;
					leftRotate(x.parent);
					bro = x.parent.right;
				}
				if ((bro.left == null || bro.left.color == black) && (bro.right == null || bro.right.color == black)) {
					// bro为黑色，而且bro的两个子结点为黑色
					bro.color = red;
					x = x.parent;
				} else {
					if (bro.right == null || bro.right.color == black) {// bro为黑色，bro左孩子为红色，bro右孩子为黑色
						bro.left.color = black;
						bro.color = red;
						rightRotate(bro);
						bro = x.parent.right;
					}
					// bro为黑色，bro右孩子为红色。
					bro.color = x.parent.color;
					x.parent.color = black;
					bro.right.color = black;
					leftRotate(x.parent);
					x = root;
				}
			} else if (x.parent != null && x == x.parent.right) {
				RBNode<T> bro = x.parent.left;
				if (bro != null && bro.color == red) {
					bro.color = black;
					x.parent.color = red;
					rightRotate(x.parent);
					bro = x.parent.left;
				}
				if ((bro.right == null || bro.right.color == black) && (bro.left == null || bro.left.color == black)) {
					bro.color = red;
					x = x.parent;
				} else {
					if (bro.left == null || bro.left.color == black) {
						bro.right.color = black;
						bro.color = red;
						leftRotate(bro);
						bro = x.parent.left;
					}

					bro.color = x.parent.color;
					x.parent.color = black;
					bro.left.color = black;
					leftRotate(x.parent);
					x = root;
				}
			}
		}
		if (x != null)
			x.color = black;
	}

	private RBNode<T> minimum(RBNode<T> x) {
		while (x != null && x.left != null) {
			x = x.left;
		}
		return x;
	}

	private RBNode<T> maximum(RBNode<T> x) {
		while (x != null && x.right != null) {
			x = x.right;
		}
		return x;
	}

	public void inorderTra() {
		inorderTra(this.root);
	}

	private void inorderTra(RBNode<T> node) {
		if (node == null)
			return;
		inorderTra(node.left);
		System.out.println(node.key);
		inorderTra(node.right);
	}

	private void print(RBNode<T> tree, T key, int direction) {

		if (tree != null) {

			if (direction == 0) // tree是根节点
				System.out.printf("%2d(B) is root\n", tree.key);
			else // tree是分支节点
				System.out.printf("%2d(%s) is %2d's %6s child\n", tree.key, tree.color == red ? "R" : "B", key,
						direction == 1 ? "right" : "left");

			print(tree.left, tree.key, -1);
			print(tree.right, tree.key, 1);
		}
	}

	public void print() {
		if (root != null)
			print(root, root.key, 0);
	}

}
