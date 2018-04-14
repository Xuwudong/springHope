package algorithm;

import java.util.Stack;

import algorithm.BTree.BNode;

public class DFS<T extends Comparable<T>> {

	private static Stack<BNode> stack = new Stack<>();

	public static <T extends Comparable<T>> void dfs(BTree<T> tree) {
		dfs(tree.root);
		System.out.println();
	}

	private static <T extends Comparable<T>> void dfs(BTree<T>.BNode node) {
		if (node == null)
			return;
		stack.push(node);
		System.out.print(node.value + "  ");
		dfs(node.left);
		dfs(node.right);
		stack.pop();
	}

}
