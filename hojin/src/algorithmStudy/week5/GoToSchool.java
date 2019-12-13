package algorithmStudy.week5;

import java.util.Arrays;

public class GoToSchool {
	static int QUOTIENT = 1000000007;
	public int solution(int m, int n, int[][]puddles) {
		int [][] path = new int[n][m];
		
		// 초기화 
		for(int[] arr :path) {
			Arrays.fill(arr, -1);
		}
		
		// 최단경로 1개인 경우 초기화
		// 오른쪽으로 1번~(m-1)번 움직이는 경로는 1개
		for(int i = 0; i < m; i++) {
			path[0][i] = 1;
		}
		// 아래로로 1번~(n-1)번 움직이는 경로는 1개
		for(int i = 0; i < n; i++) {
			path[i][0] = 1;
		}
		// 장애물 처리
		for(int[] i: puddles) {
			System.out.println("장애물");
			System.out.println("path["+(i[0]-1)+"]["+(i[1]-1)+"]"+path[i[0]][i[1]]);
			path[i[0]-1][i[1]-1] = 0;
			System.out.println("장애물 처리 후");
			System.out.println("path["+i[0]+"]["+i[1]+"]"+path[i[0]-1][i[1]-1]);
		}
		// 메모라이징???
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {			
				System.out.println("메모라이징 전");
				System.out.println("path["+i+"]["+j+"]"+path[i][j]);
				// 최단경로 정보 없으면 메모라이징
				if(path[i][j] == -1) {
					path[i][j] = path[i-1][j] + path[i][j-1];
					System.out.println("메모라이징 진행");
					System.out.println("path["+i+"]["+j+"]"+path[i][j]);
				}
			}
		}
		
		int answer = 0;
		answer = path[n-1][m-1];
		System.out.println(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] puddles = {{2,2}, {2,3}};
		GoToSchool student = new GoToSchool();
		
		student.solution(4, 3, puddles);
	}

}
