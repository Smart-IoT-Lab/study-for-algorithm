package connect_island;

import java.util.*;

public class Solution {
	// 프림 알고리즘
    public int solution(int n, int[][] costs) {
    	int sumCost = 0;
    	
    	// 연결된 노드들
        ArrayList<Integer> connected = new ArrayList<>();
        
        // 일단 0번 선택.
        connected.add(0);
        
        // 반복해.
        while(true) {
        	// 트리가 완성되었나?
        	if(connected.size() == n)
        		break;
        
        	int minCost = Integer.MAX_VALUE;	// 최소비용 선택
            int minIndex = Integer.MAX_VALUE;	// 선택된 인덱스
            int addNode = 0;					// 추가될 노드 번호

            // 1. 선택된 노드들과 연결된 선들을 확인해. 
            // 2. cost가 가장 적은 선을 선택해.
            // 3. 그 선의 노드를 추가해.
        	for (int c : connected) {
        		int start = c;	// 연결된 노드들 중 어떤 노드
                
            	// start 노드와의 연결을 찾아
                for (int i=0; i<costs.length; i++) {
                	// start가 시작점인가
                	if (costs[i][0] == start) {
                		// 그게 최소값이야?
                		if (costs[i][2] > 0 	// 사용된 연결인지 아닌지.
                				&& !connected.contains(costs[i][1])		// 이미 연결된 노드인지 아닌지
                				&& minCost > costs[i][2]) {				// cost가 최소값인지
                			addNode = costs[i][1];
                			minCost = costs[i][2];
                			minIndex = i;
                		}
                	} 
                	// start가 끝점인가
                	else if(costs[i][1] == start) {
                		// 그게 최소값이야?
                		if (costs[i][2] > 0 
                				&& !connected.contains(costs[i][0])
                				&& minCost > costs[i][2]) {
                    		addNode = costs[i][0];
                    		minCost = costs[i][2];
                			minIndex = i;
                		}
                	}
                }
        	}
        	
        	sumCost += minCost;
            costs[minIndex][2] = -1;	// 연결 이용했음을 표시
            connected.add(addNode);		// 노드 추가
        }
        
    	return sumCost;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	
    	int n = 4;
    	int[][] costs = {
    			{0,1,1},
    			{0,2,2},
    			{1,2,5},
    			{1,3,1},
    			{2,3,8} };
    	
    	System.out.println(s.solution(n, costs));
    }
    
 
}

