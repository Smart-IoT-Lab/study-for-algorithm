package failure;

import java.util.*;

class Solution {
	public int[] solution(int N, int[] stages) {
		ArrayList<Stage> answerList = new ArrayList<>();
	
		for (int stage = 1; stage < N+1; stage++) {
			int userNumber = 0;
			int failUser = 0;
			for (int i=0; i<stages.length; i++) {
				int user = stages[i];
				if (user < 0) // 이미 방문한 적 있음
					continue;
				
				if (user == stage) {
					failUser ++;
					stages[i] = -1;		// 방문 표시
				}
				userNumber++;
			}
			
			float failRate;
			if (userNumber == 0)
				failRate = 0;
			else
				failRate = (float)failUser / userNumber;
			
			Stage st = new Stage(stage, failRate);
			if (answerList.isEmpty())
				answerList.add(st);
			else {
				// 들어갈 위치를 찾아
				boolean isAdded = false;
				for (int i=0; i<answerList.size(); i++) {
					Stage s = answerList.get(i);
					if (s.failRate < st.failRate) {
						answerList.add(i, st);
						isAdded = true;
						break;
					}
				}
				// 위의 for문에서 추가되지 않았다면 실패율이 가장 작은 놈. 그냥 뒤에 붙여준다.
				if (! isAdded)
					answerList.add(st);
			}
			
//			System.out.println("[" + st.stageNumber + "] stage failure: " + st.failRate);
//			for (Stage s : answerList)
//				System.out.print(s.stageNumber + " ");
//			System.out.println();
		}
		
		int[] answer = new int[N];
		for (int i=0; i<N; i++) 
			answer[i] = answerList.get(i).stageNumber;
		
		return answer;
	}
	
	class Stage {
		int stageNumber;
		float failRate;
		
		Stage(int n, float r) {
			stageNumber = n;
			failRate = r;
		}
	}
	
	public static void main(String args[]) {
		Solution s = new Solution();
//		int N = 5;
//		int[] stages = {2,1,2,6,2,4,3,3};
		int N = 4;
		int[] stages = {4,4,4,4,4};
		
		int[] result = s.solution(N, stages);
		for (int i : result)
			System.out.print(i + " ");
	}
}