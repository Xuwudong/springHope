package algorithm;

import java.util.LinkedList;
import java.util.Queue;

import algorithm.BTree.BNode;

public class BFS<T extends Comparable<T>> {

	public static <T extends Comparable<T>> void bfs(BTree<T> tree) {
		Queue<BNode> queue = new LinkedList<>();
		System.out.println("bfs:");
		bfs(tree.root, queue);
		System.out.println();
		System.out.println("bfs2:");
		bfs2(tree.root, queue);
		System.out.println();
	}

	private static <T extends Comparable<T>> void bfs(BTree<T>.BNode node, Queue<BNode> queue) {
		if (node == null)
			return;
		System.out.print(node.value + "  ");
		if (node.left != null)
			queue.offer(node.left);
		if (node.right != null)
			queue.offer(node.right);
		@SuppressWarnings("unchecked")
		BTree<T>.BNode next = queue.poll();
		bfs(next, queue);
	}

	private static <T extends Comparable<T>> void bfs2(BTree<T>.BNode node, Queue<BNode> queue) {
		if (node == null)
			return;
		queue.offer(node);
		while (!queue.isEmpty()) {
			BNode temp = queue.poll();
			System.out.print(temp.value + "  ");
			if (temp.left != null)
					queue.offer(temp.left);
			if (temp.right != null)
					queue.offer(temp.right);
		}
	}
}
