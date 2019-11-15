package stack_queue;

import java.util.Stack;

public class Solution {
	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        Stack<Integer> decreaseStack = new Stack<>();
        
        // ù ��° ��Ҵ� ���̿� ���� ����(gradient)�� ���� �� �����Ƿ� �׳� �ٷ� �����ϰ�
        answer[0] = 0;
        
        // for���� 1���� ����
        for (int i = 1; i <heights.length; i++) {
        	int gradient = heights[i] - heights[i-1];
        	
        	// increase state
        	if (gradient >= 0) {
        		// ������ ������� ������ pop()�� 'ž'�� ���ĸ� ���� �� �ִ�.
        		while (! decreaseStack.isEmpty()) {
        			int firstEle = decreaseStack.pop();
        			if (heights[i] < heights[firstEle]) {
            			answer[i] = firstEle + 1;
            			decreaseStack.push(firstEle);
            			break;
        			}
        		}
        		
        		if (decreaseStack.isEmpty())
        			answer[i] = 0;
        	}
        	
        	// decrease state
        	else {
        		// �����ߴٴ� ���� ���� �޴� 'ž'�� �ٷ� ���� ž�� �ȴ�.
        		answer[i] = i;
        		
        		// ���ÿ� ���̰� �������� 'ž' �߰�
        		decreaseStack.push(i-1);
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		int[] heights = {6,9,5,7,4};

		for (int i : solution.solution(heights)) 
			System.out.print(i + " ");
		System.out.println();
	}
}
