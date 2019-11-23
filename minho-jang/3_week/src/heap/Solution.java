package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
	
	/**
	 * Heap�� �̿��غ��������� �� �ȵ�...
	 */
	public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        LinkedList<HeapNode> heap = new LinkedList<>();
        
        int day = 0;
        int currentStock = stock;
        int savedDay = 0;
        while (day < k) {
        	// System.out.println(day + " day");
        	// ��� ����.
        	if (currentStock == 0) {
        		// ���� ���� ������ ���޷��� ����.
        		// Insert into Heap
                for (int i = 0; i < dates.length; i++) {
                	if (dates[i] > day && dates[i] < savedDay)
                		break;
                	
                	HeapNode node = new HeapNode(i, dates[i], supplies[i]);
                	heap.addLast(node);
                	int pos = heap.size() - 1;	// ���Ե� �������� �ε���
                	
                	int parentPos = (pos + 1) / 2 - 1;
                	while (pos > 0 && heap.get(pos).supplies > heap.get(parentPos).supplies) {
                		Collections.swap(heap, pos, parentPos);
                		pos = parentPos;
                	}
                }
                savedDay = day;
                
        		// ���� �� ���� ���� �ִ� ���� �����Ѵ�.
        		// Delete from Heap
        		HeapNode del = heap.removeFirst();
        		heap.addFirst(heap.removeLast());
        		
        		int pos = del.index;
        		
        		while (true) {
        			int childPos = (pos + 1) * 2 - 1;
        			if (childPos > heap.size() - 2) 	// ���� �Ǵ� ������ �ڽ��� size�� �Ѵ� ���� ����Ű�� ���
        				break;
        			
        			if (heap.get(childPos).supplies > heap.get(childPos+1).supplies) {
        				Collections.swap(heap,  pos, childPos);
        				pos = childPos;
        			} else if (heap.get(childPos).supplies < heap.get(childPos+1).supplies) { 
        				Collections.swap(heap,  pos, childPos+1);
        				pos = childPos+1;
        			} else 
        				break;
        		}

        		currentStock += del.supplies;
        		answer++;
        	}
        	
        	currentStock--;
        	day++;
        }
        
        return answer;
    }
	
	/**
	 * ��Ȯ��  �׽�Ʈ
	 * �׽�Ʈ 1 ��	��� (0.86ms, 43MB)
	 * �׽�Ʈ 2 ��	��� (1.48ms, 43.1MB)
	 * �׽�Ʈ 3 ��	��� (1.11ms, 42.7MB)
	 * �׽�Ʈ 4 ��	��� (2.35ms, 43.1MB)
	 * �׽�Ʈ 5 ��	��� (1.95ms, 42.5MB)
	 * �׽�Ʈ 6 ��	��� (1.50ms, 43MB)
	 * �׽�Ʈ 7 ��	��� (2.09ms, 42.9MB)
	 * �׽�Ʈ 8 ��	��� (1.83ms, 42.3MB)
	 * �׽�Ʈ 9 ��	��� (1.66ms, 42.9MB)
	 * �׽�Ʈ 10 ��	��� (1.37ms, 42.7MB)
	 * �׽�Ʈ 11 ��	��� (0.90ms, 42.5MB)
	 * ȿ����  �׽�Ʈ
	 * �׽�Ʈ 1 ��	���� (�ð� �ʰ�)
	 * �׽�Ʈ 2 ��	��� (7.51ms, 45.6MB)
	 * �׽�Ʈ 3 ��	��� (28.64ms, 45.9MB)
	 * 
	 * @param stock
	 * @param dates
	 * @param supplies
	 * @param k
	 * @return
	 */
	public int solution_(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        
        int day = 0;
        int currentStock = stock;
        
        // ���� �˰����� �ٸ� �׽�Ʈ�� �������, ȿ���� �׽�Ʈ1 �ð��ʰ�
        
        HashMap<Integer, Integer> date_sup = new HashMap<>();
        for (int i=0; i<dates.length; i++) 
        	date_sup.put(dates[i], supplies[i]);
        
        while (day < k) {
        	// ��� ����.
        	if (currentStock == 0) {
        		// ��� ������ ���ſ� ���޹޾Ҿ�� �ߴ�.
        		// ���� �� ���� ���� �ִ� ���� �����Ѵ�.
        		Map.Entry<Integer, Integer> maxEntry = null;
        		for (Map.Entry<Integer, Integer> entry : date_sup.entrySet()) {
        			if (entry.getKey() > day)
        				continue;
        			
        		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) 
        		    	maxEntry = entry; 	// compareTo�� �̿��� ���� ���� map���� maxEntry�� �����
        		}
        		
        		// ���� �� ���� ���� �ִ� �� �޾Ҵٰ� ġ��, ���޹޾����Ƿ� HashMap���� ����
        		currentStock += maxEntry.getValue();
        		date_sup.remove(maxEntry.getKey());
        		answer++;
        		
        	}
        	
        	currentStock--;
        	day++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int stock = 30;
		int[] dates = {2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] supplies = {1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int k = 44;
		
		Solution s = new Solution();
		System.out.println(s.solution(stock, dates, supplies, k));
	}
}

class HeapNode {
	int index;
	int date;
	int supplies;
	
	HeapNode(int i, int date, int supplies) {
		this.index = i;
		this.date = date;
		this.supplies = supplies;
	}
}
