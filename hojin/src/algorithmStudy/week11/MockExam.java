package algorithmStudy.week11;
import java.util.Arrays;

public class MockExam {
	public int[] solution(int[] answers) {
		int [] score = new int[3];
		// 5
		int [] pattern1 = {1, 2, 3, 4, 5};
		// 8
		int [] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
		// 10
		int [] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int numOfPattern1 = pattern1.length;
		int numOfPattern2 = pattern2.length;
		int numOfPattern3 = pattern3.length;
		
		for(int idx =0, length = answers.length; idx < length; idx ++) {
			int check = answers[idx];
			if(check == pattern1[idx % numOfPattern1])
				score[0] += 1;
			if(check == pattern2[idx % numOfPattern2])
				score[1] += 1;
			if(check == pattern3[idx % numOfPattern3])
				score[2] += 1;
		}
		int[] temp = score.clone();
		// System.out.println(Arrays.toString(temp));
		Arrays.sort(temp);
		// System.out.println(Arrays.toString(temp));
		int heighScore = temp[2];
		// System.out.println(heighScore);
		int cnt = 0;
		for (int scoreIdx = 0; scoreIdx < 3; scoreIdx ++) {
			if (heighScore == score[scoreIdx]) {
				cnt += 1;
			}
		}
		int[] answer = new int[cnt];
		int idx = 0;
		for (int scoreIdx = 0; scoreIdx < 3; scoreIdx ++) {
			if (heighScore == score[scoreIdx]) {
				answer[idx] = scoreIdx + 1;
				idx += 1;
			}
		}
		// System.out.println(Arrays.toString(answer));
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answers = {1, 2, 3, 4, 5};
		MockExam agent = new MockExam();
		agent.solution(answers);
	}

}
