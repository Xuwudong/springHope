package jianzhioffer.array;

import java.util.ArrayList;

/***
 * 	输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author APP
 *
 */
public class PrintMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
		ArrayList<Integer> res = printMatrix(matrix);
		print(res);
	}

	private static void print(ArrayList<Integer> res) {
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
		ArrayList<Integer> res = new ArrayList<>();
		if (right < 0 || bottom < 0)
			return res;
		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++)
				res.add(matrix[top][i]);
			for (int i = top + 1; i <= bottom; i++)
				res.add(matrix[i][right]);
			if (top != bottom)
				for (int i = right - 1; i >= left; i--)
					res.add(matrix[bottom][i]);
			if (left != right)
				for (int i = bottom - 1; i > top; i--)
					res.add(matrix[i][left]);
			top++;
			left++;
			right--;
			bottom--;
		}
		return res;
	}
}
