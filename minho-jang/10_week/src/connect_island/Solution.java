package connect_island;

import java.util.*;

public class Solution {
	// ���� �˰���
    public int solution(int n, int[][] costs) {
    	int sumCost = 0;
    	// ����� ����
        ArrayList<Integer> connected = new ArrayList<>();
        
        // �ϴ� 0�� ����.
        connected.add(0);
        
        // �ݺ���.
        while(true) {
        	// Ʈ���� �ϼ��Ǿ���?
        	if(connected.size() == n)
        		break;
        
        	int minCost = Integer.MAX_VALUE;	// �ּҺ�� ����
            int minIndex = Integer.MAX_VALUE;	// ���õ� �ε���
            int addNode = 0;					// �߰��� ��� ��ȣ

            // 1. ���õ� ����� ����� ������ Ȯ����. 
            // 2. cost�� ���� ���� ���� ������.
            // 3. �� ���� ��带 �߰���.
        	for (int c : connected) {
        		int start = c;	// ����� ���� �� � ���
                
            	// start ������ ������ ã��
                for (int i=0; i<costs.length; i++) {
                	// start�� �������ΰ�

                	if (costs[i][0] == start) {
                		// �װ� �ּҰ��̾�?
                		if (costs[i][2] > 0 	// ���� �������� �ƴ���.
                				&& !connected.contains(costs[i][1])		// �̹� ����� ������� �ƴ���
                				&& minCost > costs[i][2]) {				// cost�� �ּҰ�����
                			addNode = costs[i][1];
                			minCost = costs[i][2];
                			minIndex = i;
                		}
                	} 
                	// start�� �����ΰ�
                	else if(costs[i][1] == start) {
                		// �װ� �ּҰ��̾�?
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
            costs[minIndex][2] = -1;	// ���� �̿������� ǥ��
            connected.add(addNode);		// ��� �߰�
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

