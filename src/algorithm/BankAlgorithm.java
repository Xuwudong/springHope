package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankAlgorithm {

	public static List<Integer> threads = new ArrayList<>();

	// ÿ����Դ��ǰ�����ڷ������Ŀ
	public static Map<String, Integer> available = new ConcurrentHashMap<>();

	// ��ǰÿ�����̻������ĸ�����Դ����
	public static Map<Integer, HashMap<String, Integer>> need = new ConcurrentHashMap<>();

	/**
	 * ��ǰÿ�������Ѿ�����ĸ�����Դ���� ���̱�� -> (��Դ����->��Դ����)
	 */
	public static Map<Integer, HashMap<String, Integer>> allocated = new ConcurrentHashMap<>();

	// ��
	public static Map<String, Integer> work;

	public static void initialize() {
		available.put("A", 6);
		available.put("B", 4);
		available.put("c", 7);
	}

	public static void requestResource(int threadId, Map<String, Integer> requestMap) {
		if (!isLeagl(requestMap, need.get(threadId))) {
			throw new RuntimeException("���󲻺Ϸ���");
		}
		if (!requMapLessThenAvai(requestMap)) {
			System.err.println("��Դ����");
		} else {
			allocate(threadId, requestMap);
			if (hasDeadLock()) {
				recycle(threadId, requestMap);
				throw new RuntimeException("oop! there is a dead lock!");
			}
			System.out.println("������Դ�ɹ���");
		}
	}

	private static void recycle(int threadId, Map<String, Integer> requestMap) {
		Map<String, Integer> threadAllocate = allocated.get(threadId);
		Map<String, Integer> threadNeed = need.get(threadId);
		for (Map.Entry<String, Integer> entry : requestMap.entrySet()) {
			String key = entry.getKey();
			available.put(key, available.get(key) + entry.getValue());
			threadAllocate.put(key, threadAllocate.get(key) - entry.getValue());
			threadNeed.put(key, threadNeed.get(key) + entry.getValue());
		}
	}

	private static void allocate(int threadId, Map<String, Integer> requestMap) {
		Map<String, Integer> threadAllocate = allocated.get(threadId);
		Map<String, Integer> threadNeed = need.get(threadId);
		for (Map.Entry<String, Integer> entry : requestMap.entrySet()) {
			String key = entry.getKey();
			available.put(key, available.get(key) - entry.getValue());
			if (threadAllocate.get(key) == null)
				threadAllocate.put(key, entry.getValue());
			else
				threadAllocate.put(key, threadAllocate.get(key) + entry.getValue());
			threadNeed.put(key, threadNeed.get(key) - entry.getValue());
		}
	}

	private static boolean requMapLessThenAvai(Map<String, Integer> requestMap) {
		for (Map.Entry<String, Integer> entry : requestMap.entrySet()) {
			String key = entry.getKey();
			if (entry.getValue() > available.get(key))
				return false;
		}
		return true;
	}

	private static boolean isLeagl(Map<String, Integer> requestMap, HashMap<String, Integer> threadNeed) {
		for (Map.Entry<String, Integer> entry : requestMap.entrySet()) {
			String key = entry.getKey();
			if (requestMap.get(key) > threadNeed.get(key)) {
				return false;
			}
		}
		return true;
	}

	public static boolean hasDeadLock() {
		boolean[] finish = new boolean[threads.size()];
		work = available;
		boolean found;
		while (true) {
			found = false;
			for (int i = 0; i < threads.size(); i++) {
				if (!finish[i] && canAllocation(need.get(threads.get(i)), work)) {
					addWork(work, allocated.get(threads.get(i)));
					finish[i] = true;
					found = true;
				}
			}
			if (found == false)
				break;
		}
		for (int i = 0; i < finish.length; i++) {
			if (!finish[i])
				return true;
		}
		return false;
	}

	private static void addWork(Map<String, Integer> work2, Map<String, Integer> allocated2) {
		for (Map.Entry<String, Integer> entry : allocated2.entrySet()) {
			String type = entry.getKey();
			work2.put(type, work2.get(type) + entry.getValue());
		}
	}

	private static boolean canAllocation(HashMap<String, Integer> need, Map<String, Integer> work) {
		for (Map.Entry<String, Integer> entry : need.entrySet()) {
			String key = entry.getKey();
			int needCount = entry.getValue();
			int workCount = work.get(key);
			if (needCount > workCount) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		initialize();
		//��ʼ���߳�1
		Map<String, Integer> req_1 = new HashMap<>();
		req_1.put("A", 3);
		req_1.put("B", 3);
		HashMap<String, Integer> need_1 = new HashMap<>();
		need_1.put("A", 6);
		need_1.put("B",3);
		need.put(1, need_1);
		allocated.put(1, new HashMap<String, Integer>());
		requestResource(1, req_1);
		
		//��ʼ���߳�2
		Map<String, Integer> req_2 = new HashMap<>();
		req_2.put("A", 3);
		req_2.put("B", 3);
		HashMap<String, Integer> need_2 = new HashMap<>();
		need_2.put("A", 6);
		need_2.put("B",3);
		need.put(2, need_2);
		allocated.put(2, new HashMap<String, Integer>());
		requestResource(2, req_2);

	}

}
