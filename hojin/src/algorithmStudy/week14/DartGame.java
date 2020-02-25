package algorithmStudy.week14;

/*
테스트 1 〉	통과 (0.84ms, 42.7MB)
테스트 2 〉	통과 (0.88ms, 42.4MB)
테스트 3 〉	통과 (0.84ms, 42.7MB)
테스트 4 〉	통과 (0.96ms, 43MB)
테스트 5 〉	통과 (0.83ms, 42.9MB)
테스트 6 〉	통과 (0.95ms, 42.5MB)
테스트 7 〉	통과 (0.78ms, 42.5MB)
테스트 8 〉	통과 (0.83ms, 42.5MB)
테스트 9 〉	통과 (0.88ms, 42.4MB)
테스트 10 〉	통과 (0.89ms, 42.4MB)
테스트 11 〉	통과 (0.80ms, 42.3MB)
테스트 12 〉	통과 (0.84ms, 42.5MB)
테스트 13 〉	통과 (0.91ms, 43.1MB)
테스트 14 〉	통과 (0.90ms, 42.9MB)
테스트 15 〉	통과 (0.80ms, 42.4MB)
테스트 16 〉	통과 (0.81ms, 42.6MB)
테스트 17 〉	통과 (0.83ms, 42.7MB)
테스트 18 〉	통과 (0.83ms, 42.5MB)
테스트 19 〉	통과 (0.90ms, 43MB)
테스트 20 〉	통과 (0.87ms, 43MB)
테스트 21 〉	통과 (0.96ms, 43.1MB)
테스트 22 〉	통과 (0.80ms, 42.7MB)
테스트 23 〉	통과 (0.84ms, 42.9MB)
테스트 24 〉	통과 (0.84ms, 42.9MB)
테스트 25 〉	통과 (0.94ms, 42.7MB)
테스트 26 〉	통과 (0.89ms, 43MB)
테스트 27 〉	통과 (0.78ms, 43.2MB)
테스트 28 〉	통과 (0.89ms, 42.3MB)
테스트 29 〉	통과 (0.85ms, 42.8MB)
테스트 30 〉	통과 (0.88ms, 43.3MB)
테스트 31 〉	통과 (0.78ms, 42.6MB)
테스트 32 〉	통과 (0.86ms, 42.5MB)
 */

public class DartGame {
	public int solution(String dartResult) {
		int answer = 0;

		int currentScore = 0;
		int preScore = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			int currentCh = (int) dartResult.charAt(i);

			if (('0' <= currentCh) && (currentCh <= '9')) {

				if ((currentCh == '0') && (i != 0) && (dartResult.charAt(i - 1) == '1')) {
					currentScore = 10;
				} else {

					preScore = currentScore;
					answer += preScore;
					currentScore = currentCh % 48;
				}

			} else if (currentCh == 'S') {
				currentScore = (int) Math.pow(currentScore, 1);
			} else if (currentCh == 'D') {
				currentScore = (int) Math.pow(currentScore, 2);
			} else if (currentCh == 'T') {
				currentScore = (int) Math.pow(currentScore, 3);

			} else if (currentCh == '*') {
				currentScore = currentScore * 2;
				answer += preScore;
			} else if (currentCh == '#') {
				currentScore = (-1) * currentScore;
			}

			if (i == (dartResult.length() - 1))
				answer += currentScore;
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DartGame agent = new DartGame();
		String dartResult = "1S2D*3T";
		System.out.println("expected answer : 37");
		agent.solution(dartResult);
	}
}