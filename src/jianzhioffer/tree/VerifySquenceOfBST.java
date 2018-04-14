package jianzhioffer.tree;
/***
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * @author APP
 *
 */
public class VerifySquenceOfBST {
	public static void main(String[] args) {
		VerifySquenceOfBST v = new VerifySquenceOfBST();
		int[] a = { 4, 8, 6, 12, 16, 14, 10 };
		System.out.println(v.verifySquenceOfBST(a));
	}

	public boolean verifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0)
			return false;
		return isSequenceOfBST(sequence, 0, sequence.length-1);
	}

	private boolean isSequenceOfBST(int[] arr, int from, int to) {
		if (from >= to)
			return true;
		int root = arr[to];
		Integer middle = null;
		for (int i = 0; i < to; i++) {
			if (middle == null) {
				if (arr[i] > root)
					middle = i;
			} else if (arr[i] < root)
				return false;
		}
		if (middle == null)
			middle = 0;
		return isSequenceOfBST(arr, 0, middle - 1) && isSequenceOfBST(arr, middle, to - 1);
	}
}
