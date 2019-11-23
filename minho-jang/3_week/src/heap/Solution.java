package heap;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        
        int day = 0;
        int currentStock = stock;
        
        // TODO Heap�� �̿��Ѵٸ� dates�� supplies�� ���� ��带 dates�� ��������
        // �ִ��� ����, ���� ��¥ ������ ��带 �ϳ��� ����(pop)�Ѵ�.
        // ���� �˰����� �� �������, ȿ���� �׽�Ʈ1 �ð��ʰ�
        
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
