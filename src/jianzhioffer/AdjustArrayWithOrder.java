package jianzhioffer;

/***
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳�� ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 * 
 * @author APP
 *
 */
public class AdjustArrayWithOrder {
	// ���Ʋ������򣬵�ǰ��������������ǰ�ң�����ż��������ǰ���
	public void reOrderArray(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				for (int j = i; j > 0; j--) {
					if (array[j - 1] % 2 == 0) {
						int temp = array[j - 1];
						array[j - 1] = array[j];
						array[j] = temp;
					}
				}
			}
		}
	}
}
