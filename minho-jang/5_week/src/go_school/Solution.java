package go_school;

public class Solution {
	public int solution(int m, int n, int[][] puddles) {
        long[][] minPaths = new long[m][n];
        
        // 물에 잠긴 지역 -1으로 채워
        int[] puddle = new int[2];
        for (int i=0; i < puddles.length; i++) {
        	puddle = puddles[i];
        	minPaths[puddle[0]-1][puddle[1]-1] = -1;
        }
        
        for (int i=0; i < minPaths.length; i++) {
        	for (int j=0; j < minPaths[i].length; j++) {
        		// 시작지점 넘겨
        		if (i == 0 && j == 0) {
        			minPaths[i][j] = 1;
        			continue;
        		}
        		
        		// 물에 잠긴 지역은 넘겨
        		if (minPaths[i][j] < 0) {
        			minPaths[i][j] = 0;
        			continue;
        		}
        		
        		// 위 테두리는 위쪽이 없어
        		if (i == 0)
        			minPaths[i][j] = minPaths[i][j-1];
        			
        		// 왼쪽 테두리는 왼쪽이 없어
        		else if (j == 0)
        			minPaths[i][j] = minPaths[i-1][j];
        		
        		// (위쪽 최소경로수) + (왼쪽 최소경로수)
        		else
        			minPaths[i][j] = (minPaths[i-1][j] + minPaths[i][j-1]) % 1000000007;
        	}
        }
        
        printArr(minPaths);
        
        return (int) minPaths[m-1][n-1];
    }
	
	void printArr(long[][] arr) {
		for (int i=0; i < arr.length; i++) {
        	for (int j=0; j < arr[i].length; j++) 
        		System.out.print(arr[i][j] + " ");
        	
        	System.out.println();
        }
	}
	
	public static void main(String args[]) {

		Solution s = new Solution();
		
		int m = 4;
		int n = 3;
		int[][] puddles = {{2,1}};
		
		System.out.println(s.solution(n, m, puddles));
	}
}
