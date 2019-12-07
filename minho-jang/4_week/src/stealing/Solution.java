package stealing;

import java.util.*;

public class Solution {

    public int solution(int[] money) {
        int answer = 0;
        
        ArrayList<Integer> moneyToList = new ArrayList<>();
        for (int i : money)
        	moneyToList.add(i);
        
    	int stealMax = 0;
        for (int i=0; i < moneyToList.size(); i++) {
        	System.out.println("TEST CASE " + i + " =========================");
        	boolean[] canSteal = new boolean[moneyToList.size()];
            Arrays.fill(canSteal, true);
            
        	int steal = 0;
            // 어떤 집 선택
        	if (canSteal[i])
        		steal += moneyToList.get(i);
        	else
        		continue;
        	// 양 옆에 경보
        	alarm(canSteal, i);  
        	
        	// 나머지 집 중에서 훔쳤을 때 최대값
        	steal += stealing(moneyToList, canSteal);
        	System.out.println("TEST steal: " + steal);
        	if (stealMax < steal)
        		stealMax = steal;
        }

        return stealMax;
    }
    
    int stealing(ArrayList<Integer> moneyToList, boolean[] canSteal) {
    	int trueCount = 0;
    	for (boolean b : canSteal) {
    		System.out.println("TEST canSteal: " + b);
    		if (b)
    			trueCount++;
    	}
    	
    	// 털 수 있는 집이 없으면
    	if (trueCount == 0)
    		return 0;
    	
    	// 털 수 있는 집이 3개 미만
    	if (trueCount < 3) {
    		// 걍 최대값 리턴
    		int max = 0;
    		int idx = 0;
    		for (int i : moneyToList) {
    			if (canSteal[idx])
    				if (max < i)
    					max = i;
    			else
    				continue;
    			idx++;
    		}
    		System.out.println("TEST Max: " + max);
    		return max;
    	}
    	
    	int stealMax = 0;
    	boolean[] tmp;
    	for (int i=0; i < moneyToList.size(); i++) {
    		int steal = 0;
    		tmp = Arrays.copyOf(canSteal, canSteal.length);
    		
            // 어떤 집 선택
        	if (tmp[i])
        		steal += moneyToList.get(i);
        	else
        		continue;
        	// 양 옆에 경보
        	System.out.println("TEST selcet i: " + i);
        	alarm(tmp, i);
        	
        	steal += stealing(moneyToList, tmp);
        	if (stealMax < steal)
        		stealMax = steal;
        }
    	
    	return stealMax;
	}

	void alarm(boolean[] b, int idx) {
    	// 본인
    	b[idx] = false;
    	
    	// 왼쪽
    	if (idx == 0)
    		b[b.length-1] = false;
    	else
    		b[idx-1] = false;
    	
    	// 오른쪽
    	if (idx == b.length-1)
    		b[0] = false;
    	else
    		b[idx+1] = false;
    }
	
	public static void main(String args[]) {
		Solution s = new Solution();
		
		int[] money = {1,100,1,1,101,1};
		System.out.println(s.solution(money));
	}
}
