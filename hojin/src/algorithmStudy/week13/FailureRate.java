package algorithmStudy.week13;

import java.util.Arrays;
import java.util.HashMap;

public class FailureRate{
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		
		HashMap<Integer, Double> failureRate = new HashMap<Integer, Double>(); 		
		Arrays.parallelSort(stages);
		
		int challenger = stages.length;
		int restartIndex = 0;
		// 최대 반복 100,000,000 i = 500, j = 200,000, sorting으로 1억 이하 진행
		for(int i = 1; i < N + 1; i++) {
			int stopPlayer = 0;
			for(int j = restartIndex, maxIndex = stages.length; j < maxIndex; j++) {
				// 현재 스테이지에 멈춰있는지 확인
				if(stages[j] == i) {
					stopPlayer++;
				}
				else
					break;
			}
			// 속도 향상을 위해 restartIndex 갱신
			restartIndex += stopPlayer;
			// 실패율 계산
			// 스테이지에 도달한 유저(멈춘유저)가 없으면 실패율 0
			if(stopPlayer == 0) {
				failureRate.put(i, (double) 0);
			} else
				failureRate.put(i, (double) stopPlayer / challenger);
			
			// 다음 스테이지 도전자 갱신
			challenger -= stopPlayer;
		}
		for(int i = 0; i < N; i++) {
			Double maxRate = -0.1;
			int maxKey = 0;
			for (Integer key : failureRate.keySet()) {
				Double currentRate = failureRate.get(key);
				if(maxRate < currentRate) {
					maxRate = currentRate;
					maxKey = key;
				}
			}
			answer[i] = maxKey;
			failureRate.remove(maxKey);
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FailureRate agent = new FailureRate();
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		System.out.println("3, 4, 2, 1, 5");
		agent.solution(N, stages);
	}
}