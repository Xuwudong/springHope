package qiuzhao;

public class RBTreeTest {

	private static final int a[] = { 10, 40, 30, 60, 90, 70, 20, 50, 80 };
	private static boolean mDebugInsert = false; // "插入"动作的检测开关(false，关闭；true，打开)
	private static boolean mDebugDelete = false; // "删除"动作的检测开关(false，关闭；true，打开)

	public static void main(String[] args) {
		int i, ilen = a.length;
		RBTree<Integer> tree = new RBTree<Integer>();

		System.out.printf("== 原始数据: ");
		for (i = 0; i < ilen; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");

		mDebugInsert = true;
		for (i = 0; i < ilen; i++) {
			tree.insert(a[i]);
			// 设置mDebugInsert=true,测试"添加函数"

			if (mDebugInsert) {
				System.out.printf("== 添加节点: %d\n", a[i]);
				System.out.printf("== 树的详细信息: \n");
				tree.print();
				System.out.printf("\n");
			}
		}

		System.out.printf("\n== 中序遍历: ");
		tree.inorderTra();
		System.out.printf("\n");

		// 设置mDebugDelete=true,测试"删除函数"
		mDebugDelete = true;
		if (mDebugDelete) {
			for (i = 0; i < ilen; i++) {
				tree.delete(a[i]);

				System.out.printf("== 删除节点: %d\n", a[i]);
				System.out.printf("== 树的详细信息: \n");
				tree.print();
				System.out.printf("\n");
			}
		}

	}
}
