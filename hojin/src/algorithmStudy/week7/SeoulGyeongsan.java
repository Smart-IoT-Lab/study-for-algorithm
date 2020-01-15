package algorithmStudy.week7;

public class SeoulGyeongsan {
	public int solution(int K, int[][] travel) {
        int answer = 0;
        int pathLength = travel.length;
        int [][] dp = new int[pathLength][K+1];
        
        dp[0][travel[0][0]] = travel[0][1];
        dp[0][travel[0][2]] = travel[0][3];
        
        for(int i = 1; i < pathLength; i++) {
        	
        	for (int j = 0; j <= K ; j ++){
        		// 
        		if (dp[i-1][j] == 0)
                    continue;
        		if (j + travel[i][0] <= K) {
        			dp[i][j+travel[i][0]] = Math.max(dp[i][j + travel[i][0]], dp[i-1][j] + travel[i][1]);
        			answer = Math.max(dp[i][j+travel[i][0]], answer);
        		}
        		if (j + travel[i][2] <= K) {
        			dp[i][j+travel[i][2]] = Math.max(dp[i][j + travel[i][2]], dp[i-1][j] + travel[i][3]);
        			answer = Math.max(dp[i][j+travel[i][2]], answer);
        		}
            }
        }
        System.out.println(answer);
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeoulGyeongsan SeoulGyeongsanTraveler = new SeoulGyeongsan();
		int k = 1650;
		int[][] travel = {{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}};
		SeoulGyeongsanTraveler.solution(k, travel);
	}

}
