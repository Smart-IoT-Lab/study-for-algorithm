package stack_queue;

import java.util.Stack;

public class Solution {
	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        Stack<Integer> decreaseStack = new Stack<>();
        
        // 첫 번째 요소는 높이에 대한 기울기(gradient)를 따질 수 없으므로 그냥 바로 대입하고
        answer[0] = 0;
        
        // for문은 1부터 시작
        for (int i = 1; i <heights.length; i++) {
        	int gradient = heights[i] - heights[i-1];
        	
        	// increase state
        	if (gradient >= 0) {
        		// 스택이 비어있지 않으면 pop()의 '탑'이 전파를 받을 수 있다.
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
        		// 감소했다는 것은 전파 받는 '탑'이 바로 왼쪽 탑이 된다.
        		answer[i] = i;
        		
        		// 스택에 높이가 감소중인 '탑' 추가
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
