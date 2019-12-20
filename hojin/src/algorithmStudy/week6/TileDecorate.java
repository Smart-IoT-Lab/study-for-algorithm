package algorithmStudy.week6;

public class TileDecorate {
	// 프로그래머스 타일 장식물 문제
	// 사각형이 3개째일때 부터 둘레를 구하는 공식이 생김
	// (현재 자신의 변 + 전 사각형의 변) * 2 (변이 두개이므로 
	// (전 사각형의 변 + 전전 사각형의 변) * 2
	// 인덱스로 표현하면 ([i] + [i-1]) * 2 + ([i-1] + [i-2]) * 2 
	public long solution(int N) {
		// switch 버전
		long answer = 0;
		int indexN = N - 1;

		long[] dp = new long[N];
		switch (N) {
		case 1:
			answer = 4;
			break;
		case 2:
			answer = 6;
			break;
		default:
			dp[0] = 1;
			dp[1] = 1;
			for (int i = 2; i < N; i++) {
				System.out.println(i);
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			answer = ((dp[indexN] + dp[indexN - 1]) + (dp[indexN - 1] + dp[indexN - 2])) * 2;
		}
		System.out.println(answer);
		return answer;
	}

	public long solution2(int N) {
		// if문 버전
		long answer = 0;
		int indexN = N - 1;

		long[] dp = new long[N];
		if (N == 1) {
			answer = 4;
		} else if (N == 2) {
			answer = 6;
		} else {
			dp[0] = 1;
			dp[1] = 1;
			for (int i = 2; i < N; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			answer = ((dp[indexN] + dp[indexN - 1]) + (dp[indexN - 1] + dp[indexN - 2])) * 2;
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TileDecorate calcAgent = new TileDecorate();
		calcAgent.solution(5);
		
	}

}
