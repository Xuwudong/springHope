package algorithm;

public class BTreeTest {
	public static void main(String[] args) {
		int[] arr = { 12, 3, 54, 2, 465, 5, 46, 8, 6, 4, 1, 7, 9, 10, 11 };
		BTree<Integer> bTree = new BTree<Integer>();
		bTree = buildBTree(bTree, arr);
		bTree.inorder_tra();
		DFS.dfs(bTree);
		BFS.bfs(bTree);
		delete(bTree, arr);
	}

	private static void delete(BTree<Integer> bTree, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			bTree.delete(arr[i]);
			bTree.inorder_tra();
		}
	}

	private static BTree<Integer> buildBTree(BTree<Integer> bTree, int[] arr) {
		for (int i = 0; i < arr.length; i++)
			bTree.insert(arr[i]);
		return bTree;
	}
}
