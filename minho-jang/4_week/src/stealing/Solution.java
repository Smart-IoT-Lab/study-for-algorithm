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
            // � �� ����
        	if (canSteal[i])
        		steal += moneyToList.get(i);
        	else
        		continue;
        	// �� ���� �溸
        	alarm(canSteal, i);  
        	
        	// ������ �� �߿��� ������ �� �ִ밪
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
    	
    	// �� �� �ִ� ���� ������
    	if (trueCount == 0)
    		return 0;
    	
    	// �� �� �ִ� ���� 3�� �̸�
    	if (trueCount < 3) {
    		// �� �ִ밪 ����
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
    		
            // � �� ����
        	if (tmp[i])
        		steal += moneyToList.get(i);
        	else
        		continue;
        	// �� ���� �溸
        	System.out.println("TEST selcet i: " + i);
        	alarm(tmp, i);
        	
        	steal += stealing(moneyToList, tmp);
        	if (stealMax < steal)
        		stealMax = steal;
        }
    	
    	return stealMax;
	}

	void alarm(boolean[] b, int idx) {
    	// ����
    	b[idx] = false;
    	
    	// ����
    	if (idx == 0)
    		b[b.length-1] = false;
    	else
    		b[idx-1] = false;
    	
    	// ������
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
