package jianzhioffer;

/***
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序， 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author APP
 *
 */
public class AdjustArrayWithOrder {
	// 类似插入排序，当前数是奇数，就往前找，遇到偶数就往它前面插
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
