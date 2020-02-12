package fromSeoul_toKyungsan;

import java.util.*;

public class Solution {
	int[][] travel;
	int[][] memo;
	
	int count = 0;
	
	public int solution(int K, int[][] travel) {
        int answer = 0;
        
        this.travel = travel;
        
        // memo: �� ������ �̿밡���� �ð�(0)�� ��ݾ�(1)
        // �ʱ�ȭ
        memo = new int[travel.length][2];
        for (int i=0; i<travel.length; i++)
        	Arrays.fill(memo[i], -1);
        
        answer = doTravel(K, 0);
        
        return answer;
    }
	
	int doTravel(int time, int section) {
		if (time < 0)
			return -1;
		
		if (section >= travel.length)
			return 0;
		
		
		if (memo[section][0] != -1 && memo[section][0] >= time) {
			System.out.println("MEMO !!");
			return memo[section][1];
		}
		
		int walk = doTravel(time-travel[section][0], section+1);
		int bicycle = doTravel(time-travel[section][2], section+1);
		
		// � ������ �Ͽ��� ��, �ð��� �ʰ��ȴٸ� 0�� �����ϵ��� �Ѵ�.
		if (walk == -1)
			walk = 0;
		else 
			walk += travel[section][1];
		
		if (bicycle == -1)
			bicycle = 0;
		else 
			bicycle += travel[section][3];
		
		System.out.println("section: " + section + "\t K = " + time
				+ "\n  walk = " + (walk) + "\n  bicycle = " + (bicycle));
		
		int maxValue = Math.max(walk, bicycle);
		memo[section][0] = time;
		memo[section][1] = maxValue;
		return maxValue;
	}
}
