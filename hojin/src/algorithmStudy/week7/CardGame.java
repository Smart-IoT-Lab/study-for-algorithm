package algorithmStudy.week7;

public class CardGame {
    public int solution(int[] left, int[] right) {
        int answer = 0;
        int numOfHalfCard = left.length;
        int [][] dp = new int[numOfHalfCard+1][numOfHalfCard+1];
        
        for (int i = 0; i < numOfHalfCard; i++) {
        	for(int j = 0; j < numOfHalfCard; j++) {
        		// 오른쪽 카드가 작은 경우
        		// 오른쪽 카드 버림
        		if (left[i] > right[j]) {
        			dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j] + right[j]);
        		}
        		// 오른쪽 카드가 크거나 같을 경우
        		else{
        			// 둘 다 버림
        			dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]);
        			// 왼쪽 카드만 버림
        			dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]); 
        		}
        	}
        }
        
        //둘중 하나 다버리면 끝남        
        for(int i = 0; i < numOfHalfCard+1; i++) {
        	answer = Math.max(answer, dp[i][numOfHalfCard]);
        	answer = Math.max(dp[numOfHalfCard][i], answer);
        }
        
        System.out.println(answer);
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardGame cardGammer = new CardGame();
		int[] left = {3, 2, 5};
		int[] right = {2, 4, 1};
		cardGammer.solution(left, right);
	}

}
