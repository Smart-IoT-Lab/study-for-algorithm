package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
	
	/**
	 * Heap을 이용해보려했지만 잘 안됨...
	 */
	public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        LinkedList<HeapNode> heap = new LinkedList<>();
        
        int day = 0;
        int currentStock = stock;
        int savedDay = 0;
        while (day < k) {
        	// System.out.println(day + " day");
        	// 재고가 없다.
        	if (currentStock == 0) {
        		// 현재 기준 과거의 공급량을 저장.
        		// Insert into Heap
                for (int i = 0; i < dates.length; i++) {
                	if (dates[i] > day && dates[i] < savedDay)
                		break;
                	
                	HeapNode node = new HeapNode(i, dates[i], supplies[i]);
                	heap.addLast(node);
                	int pos = heap.size() - 1;	// 삽입된 데이터의 인덱스
                	
                	int parentPos = (pos + 1) / 2 - 1;
                	while (pos > 0 && heap.get(pos).supplies > heap.get(parentPos).supplies) {
                		Collections.swap(heap, pos, parentPos);
                		pos = parentPos;
                	}
                }
                savedDay = day;
                
        		// 과거 중 가장 많이 주는 날을 선택한다.
        		// Delete from Heap
        		HeapNode del = heap.removeFirst();
        		heap.addFirst(heap.removeLast());
        		
        		int pos = del.index;
        		
        		while (true) {
        			int childPos = (pos + 1) * 2 - 1;
        			if (childPos > heap.size() - 2) 	// 왼쪽 또는 오른쪽 자식이 size를 넘는 곳을 가리키는 경우
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
	 * 정확성  테스트
	 * 테스트 1 〉	통과 (0.86ms, 43MB)
	 * 테스트 2 〉	통과 (1.48ms, 43.1MB)
	 * 테스트 3 〉	통과 (1.11ms, 42.7MB)
	 * 테스트 4 〉	통과 (2.35ms, 43.1MB)
	 * 테스트 5 〉	통과 (1.95ms, 42.5MB)
	 * 테스트 6 〉	통과 (1.50ms, 43MB)
	 * 테스트 7 〉	통과 (2.09ms, 42.9MB)
	 * 테스트 8 〉	통과 (1.83ms, 42.3MB)
	 * 테스트 9 〉	통과 (1.66ms, 42.9MB)
	 * 테스트 10 〉	통과 (1.37ms, 42.7MB)
	 * 테스트 11 〉	통과 (0.90ms, 42.5MB)
	 * 효율성  테스트
	 * 테스트 1 〉	실패 (시간 초과)
	 * 테스트 2 〉	통과 (7.51ms, 45.6MB)
	 * 테스트 3 〉	통과 (28.64ms, 45.9MB)
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
        
        // 현재 알고리즘은 다른 테스트는 통과지만, 효율성 테스트1 시간초과
        
        HashMap<Integer, Integer> date_sup = new HashMap<>();
        for (int i=0; i<dates.length; i++) 
        	date_sup.put(dates[i], supplies[i]);
        
        while (day < k) {
        	// 재고가 없다.
        	if (currentStock == 0) {
        		// 재고가 없으면 과거에 공급받았어야 했다.
        		// 과거 중 가장 많이 주는 날을 선택한다.
        		Map.Entry<Integer, Integer> maxEntry = null;
        		for (Map.Entry<Integer, Integer> entry : date_sup.entrySet()) {
        			if (entry.getKey() > day)
        				continue;
        			
        		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) 
        		    	maxEntry = entry; 	// compareTo를 이용해 제일 높은 map값이 maxEntry에 저장됨
        		}
        		
        		// 과거 중 가장 많이 주는 날 받았다고 치고, 공급받았으므로 HashMap에서 삭제
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
