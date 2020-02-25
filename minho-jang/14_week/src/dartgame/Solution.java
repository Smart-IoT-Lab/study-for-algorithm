package dartgame;

public class Solution {
	public int solution(String dartResult) {
		int answer = 0;
        int[] scores = new int[3];

        // 10점은 A로 교체
		dartResult = dartResult.replace("10", "A");

		char[] resultArr = dartResult.toCharArray();
		int startIndex = 0;

		// for문 돌면서 3경기를 치뤄
		for (int gameCount = 0; gameCount < 3; gameCount++) {
            
            // 경기 정보 읽어
			char pointChar = resultArr[startIndex];
			char square = resultArr[startIndex + 1];
			char option;
			if (resultArr.length <= startIndex + 2) { // 인덱스초과 참조 방어
				option = '0';
			} else {
				option = resultArr[startIndex + 2];
			}
            
            // System.out.println("TEST " + (gameCount+1) + " " + pointChar + square + option);

            // 점수 계산            
            int point = 0;
            if (pointChar == 'A')
                point = 10;
            else 
                point = Integer.valueOf(pointChar) - '0';
            
            int sq = 0;
            if (square == 'S')
                sq = 1;
            else if (square == 'D')
                sq = 2;
            else if (square == 'T')
                sq = 3;
            
            int sqTotal = point;
            for (int i=1; i<sq; i++)
                sqTotal *= point;
            // System.out.println("TEST sqTotal: " + sqTotal);
            scores[gameCount] = sqTotal;
                
            // option 계산
			if ((option >= '0' && option <= '9') || option == 'A') { // option이 숫자이면?
                // System.out.println("TEST no option");
				startIndex += 2;
			} else { 
                // 스타상 점수 계산
                if (option == '*') {
                    // 1경기 스타상은 1경기만 두 배
                    if (gameCount == 0) {
                        scores[gameCount] *= 2;
                    } 
                    // 전 경기와 현재 경기 점수 두 배
                    else {
                        scores[gameCount-1] *= 2;
                        scores[gameCount] *= 2;
                    }
                } 
                // 아차상은 현재 경기 마이너스
                else if (option == '#') {
                    scores[gameCount] *= -1;
                } 

				startIndex += 3;
			}
		}
        
        for (int s : scores) {
            // System.out.println("score: " + s);
            answer += s;
        }

		return answer;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		// return 37
		String dartResult = "10S10S10S";
		
		System.out.println(s.solution(dartResult));	
	}
}
