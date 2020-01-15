package algorithmStudy.week10;

import java.util.Arrays;

public class Lifeboat {
	public int solution(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people);
		int minIndex = 0;
		int maxIndex = people.length - 1;
		int availableWeight = limit;
		while(true) {
			// 남은 사람이 한명인 경우
			if(minIndex == maxIndex) {
				answer++;
				break;
			}
			availableWeight = limit - people[maxIndex];
			maxIndex--;
			
			if (availableWeight >= people[minIndex]) {
				minIndex++;
			}
			answer++;
			// 두명을 태우고 더이상 사람이 없을 경우
			if(minIndex > maxIndex) {
				break;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] people = {70, 50, 80, 50};
		int limit = 100;
		Lifeboat lifeboatAgent = new Lifeboat();
		lifeboatAgent.solution(people, limit);
	}

}
