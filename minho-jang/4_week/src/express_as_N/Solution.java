package express_as_N;

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        LinkedHashMap<Integer, Integer> useN = new LinkedHashMap<>();

        useN.put(11111, 6);
        useN.put(1111, 5);
        useN.put(111, 4);
        useN.put(11, 3);
        useN.put(N, 1);
        useN.put(1, 2);
        
        LinkedHashMap<Integer, Integer> count = new LinkedHashMap<>();
        count.put(11111, 0);
        count.put(1111, 0);
        count.put(111, 0);
        count.put(11, 0);
        count.put(N, 0);
        count.put(1, 0);
        
        int current = number;
        while (current > 0) {
            for (int i : useN.keySet()) {
                if (i <= current) {
                    current -= i;
                    count.replace(i, count.get(i)+1);
                    break;
                }
            }
        }
        
        while (! isAllZero(count)) {
        	int n = 0;
        	for (int i : count.keySet()) {
            	if (count.get(i) == 0)
            		continue;
            	answer += useN.get(i);
                count.replace(i, count.get(i)-1);
                if (i != N)
                	n++;
            }
        	answer -= n-1;
        }
        
        if (answer > 8)
        	answer = -1;
        
        return answer;
    }
    
    boolean isAllZero(LinkedHashMap<Integer, Integer> count) {
    	boolean check = true;
    	
    	for (int i : count.values())
    		if (i != 0)
    			check = false;
    		
    	return check;
    }
    
    public static void main(String args[]) {
    	Solution s = new Solution();
    	
    	int N = 2;
    	int number = 11;
    	
    	System.out.println(s.solution(N, number))
    	;
    }
}