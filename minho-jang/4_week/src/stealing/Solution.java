package stealing;

import java.util.*;

public class Solution {

	// HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
	
    public int solution(int[] money) {
        int answer = 0;
        
        ArrayList<Integer> moneyToList = new ArrayList<>();
        for (int i : money)
        	moneyToList.add(i);
        
    	answer = stealing(moneyToList, 0, 0);
    	// System.out.println("Memo size: " + map.size());
        return answer;
    }
    
    //											접근불가능한 집 개수
    int stealing(ArrayList<Integer> moneyToList, int stealCount, int idx) {
    	for(int i : moneyToList)
    		System.out.println("TEST temp[]: " + i);
    	
    	// 메모이제이션
//    	if (map.containsKey(moneyToList)) {
//    		System.out.println("Memo @@ " + map.get(moneyToList));
//    		
//    		return map.get(moneyToList);
//    	}
    	
    	// 털 수 있는 집이 3개 미만
    	if (moneyToList.size()-stealCount < 3) {
    		if (moneyToList.size() == stealCount)	return 0;
    		
    		// 걍 최대값 리턴
        	int max = Collections.max(moneyToList);
        	//map.put(moneyToList, max);
    		return max;
    	}
    	
    	int stealMax = 0;
    	for (int i=idx; i < moneyToList.size(); i++) {
    		ArrayList<Integer> temp = (ArrayList<Integer>) moneyToList.clone();
    		int steal = 0;
    		
            // 어떤 집 선택
        	if (temp.get(i) > 0)
        		steal += temp.get(i);
        	else
        		continue;

        	System.out.println("TEST selcet i: " + i);
        	// 양 옆에 경보
        	int cnt = alarm(temp, i);
        	
        	steal += stealing(temp, stealCount+cnt, i);
    		System.out.println("=======================result: " + steal + "====");
        	if (stealMax < steal)
        		stealMax = steal;
        }
    	
    	// 메모이제이션
    	// map.put(moneyToList, stealMax);
    	
    	return stealMax;
	}

	int alarm(ArrayList<Integer> a, int idx) {
		int cnt=0;
		
		int leftIdx = 0;
		int rightIdx = 0;
    	// 털린 본인
    	a.set(idx, -1);
    	cnt++;
    	
    	// 경보울린데 -1
    	// 왼쪽
    	if (idx == 0)
    		leftIdx = a.size()-1;
    	else
    		leftIdx = idx-1;
    	
    	// 오른쪽
    	if (idx == a.size()-1)
    		rightIdx = 0;
    	else
    		rightIdx = idx+1;
    	
    	if (a.get(leftIdx) <= 0)
    		cnt++;
    	else 
    		a.set(leftIdx, -1);
    	
    	if (a.get(rightIdx) <= 0)
    		cnt++;
    	else 
    		a.set(rightIdx, -1);
    	
    	return cnt;
    }
	
	public static void main(String args[]) {
		Solution s = new Solution();
		
		int[] money = {1,101,1,1,102,1};
		System.out.println(s.solution(money));
	}
}
