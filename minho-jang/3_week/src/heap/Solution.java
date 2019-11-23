package heap;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        
        int day = 0;
        int currentStock = stock;
        
        // TODO Heap을 이용한다면 dates와 supplies를 묶은 노드를 dates를 기준으로
        // 최대힙 만들어서, 현재 날짜 이전꺼 노드를 하나씩 제거(pop)한다.
        // 현재 알고리즘은 다 통과지만, 효율성 테스트1 시간초과
        
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
