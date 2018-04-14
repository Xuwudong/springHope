package qiuzhao;

public class RBTreeTest {

	private static final int a[] = { 10, 40, 30, 60, 90, 70, 20, 50, 80 };
	private static boolean mDebugInsert = false; // "����"�����ļ�⿪��(false���رգ�true����)
	private static boolean mDebugDelete = false; // "ɾ��"�����ļ�⿪��(false���رգ�true����)

	public static void main(String[] args) {
		int i, ilen = a.length;
		RBTree<Integer> tree = new RBTree<Integer>();

		System.out.printf("== ԭʼ����: ");
		for (i = 0; i < ilen; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");

		mDebugInsert = true;
		for (i = 0; i < ilen; i++) {
			tree.insert(a[i]);
			// ����mDebugInsert=true,����"��Ӻ���"

			if (mDebugInsert) {
				System.out.printf("== ��ӽڵ�: %d\n", a[i]);
				System.out.printf("== ������ϸ��Ϣ: \n");
				tree.print();
				System.out.printf("\n");
			}
		}

		System.out.printf("\n== �������: ");
		tree.inorderTra();
		System.out.printf("\n");

		// ����mDebugDelete=true,����"ɾ������"
		mDebugDelete = true;
		if (mDebugDelete) {
			for (i = 0; i < ilen; i++) {
				tree.delete(a[i]);

				System.out.printf("== ɾ���ڵ�: %d\n", a[i]);
				System.out.printf("== ������ϸ��Ϣ: \n");
				tree.print();
				System.out.printf("\n");
			}
		}

	}
}
