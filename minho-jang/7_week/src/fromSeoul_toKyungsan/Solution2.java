package fromSeoul_toKyungsan;

import java.util.*;

public class Solution2 {
	int[][] travel;
	
	HashMap<String, Integer> memo;
    
    public int solution(int K, int[][] travel) {
        int answer = 0;
        
        memo = new HashMap<>();
        this.travel = travel;
        answer = doTravel(0, K);
        
        for (String k : memo.keySet())
        	System.out.println(k + ": " + memo.get(k));
        
        
        return answer;
    }
    
    int doTravel(int section, int time) {
    	System.out.println("section: " + section);
        if (section == travel.length)
            return 0;
        
        String key = String.valueOf(section) + " " + String.valueOf(time);
        
        // 단순히 section과 time이 같은지 확인
        if (memo.containsKey(key)) {
        	System.out.println("!! MEMO !!");
        	return memo.get(key);
        }
        
        
        int walkMoney, bikeMoney;
        
        if (time-travel[section][0] < 0)
        	walkMoney = 0;
        else
        	walkMoney = doTravel(section+1, time-travel[section][0]) + travel[section][1];
        
        if (time-travel[section][2] < 0)
        	bikeMoney = 0;
        else
        	bikeMoney = doTravel(section+1, time-travel[section][2]) + travel[section][3];
        
        System.out.println("    walk: " + walkMoney);
        System.out.println("    bike: " + bikeMoney);

        int max = Math.max(walkMoney, bikeMoney);
        memo.put(key, max);
        return max;
    }
    
    public static void main(String args[]) {
		Solution2 s = new Solution2();
		
		// Test case 1 : return 660
//		int K = 1650;
//		int[][] travel = {
//			{500, 200, 200, 100},
//			{800, 370, 300, 120},
//			{700, 250, 300, 90}
//		};
		
		// Test case 2 : return 5900
		int K = 3000;
		int[][] travel = {
				{1000, 2000, 300, 700},
				{1100, 1900, 400, 900},
				{900, 1800, 400, 700},
				{1200, 2300, 500, 1200}
		};
		
		System.out.println(s.solution(K, travel));
//		System.out.println(s.count);	// 2^(구간 수 + 1) - 1
	}
}
