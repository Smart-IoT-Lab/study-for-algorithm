package exam;

import java.util.*;

public class Solution {
	public int[] solution(int[] answers) {
		int[] student0 = { 1, 2, 3, 4, 5 };
		int[] student1 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] student2 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		
		// 점수 계산
		int[] score = new int[3];
		for (int i = 0; i < answers.length; i++) {

			if (answers[i] == student0[i % student0.length]) {
				score[0]++;
			}
			if (answers[i] == student1[i % student1.length]) {
				score[1]++;
			}
			if (answers[i] == student2[i % student2.length]) {
				score[2]++;
			}
		}

		// 출력하기 위해 정렬

		int max = score[0]; // 최대값 구해
		for (int i = 0; i < score.length; i++) 
			if (max < score[i]) 
				max = score[i];
		
		// 구한 최대값과 같은 인덱스를 집어넣어
		ArrayList<Integer> answer = new ArrayList<>();

		for (int i = 0; i < score.length; i++) 
			if (max == score[i])
				answer.add(i+1);

		// ArrayList to array
		int[] answerList = new int[answer.size()];
		for (int i = 0; i < answer.size(); i++)
			answerList[i] = answer.get(i);

		return answerList;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] answers = {1,2,3,4,5};
		// int[] answers = {1,3,2,4,2};
		
		int[] print = s.solution(answers);
		for (int i : print) {
			System.out.print(i +" ");
		}
	}
}
