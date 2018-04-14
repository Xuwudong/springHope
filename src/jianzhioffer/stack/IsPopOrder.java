package jianzhioffer.stack;

import java.util.Stack;

/***
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳��
 * ����4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С� ��ע�⣺���������еĳ�������ȵģ�
 * 
 * @author APP
 *
 */
public class IsPopOrder {
	public boolean isPopOrder(int[] pushA, int[] popA) {
		int pIndex = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.isEmpty() && stack.peek() == popA[pIndex]) {
				stack.pop();
				pIndex++;
			}
		}
		return stack.isEmpty();
	}
}
