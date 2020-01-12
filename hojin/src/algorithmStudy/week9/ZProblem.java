package algorithmStudy.week9;

import java.util.Scanner;

public class ZProblem {
	static int answer = 0;
	public void solution1(int N, int r, int c) {
		if(N == 1)
		{
			System.out.print((2*r + c));
		} else {
			int numOfZ = (int) Math.pow(2, 2 * (N - 1));
			System.out.println("numOfZ : "+numOfZ);
			
			int row = (int) Math.sqrt(numOfZ);
			System.out.println("row : "+row);
			
			int remainR = r % 2;
			int remainC = c % 2;
			System.out.print(
					4 * (row * (int)(r/2) + (int)(c/2)) + (remainR * 2 + remainC)
			);
		}
	}
	public int solution(int N, int r, int c) {
		if(N == 1) {
			answer = 2*r + c;
			return answer;
		}
		// 전체 Z의 개수
		int numOfZ = (int) Math.pow(2, 2 * (N - 1));
		// 사분면 당 Z의 개수
		int quarterOfNumOfZ = (int) numOfZ / 4;
		
		int x = (int) Math.pow(2, N-1);
		int y = x;
		// 1사분면
		if (c >= x && r < y) {
			// 2사분면 더해줌					 // c 좌표 줄임
			answer = quarterOfNumOfZ * 4 + solution(N-1, r, c-x);			
		}
		// 2사분면
		else if(c < x && r < y) {
			// Z값 안더해줌
			// 좌표 변경 없음
			answer = solution(N-1, r, c);
		}
		// 3사분면
		else if(c < x && r >= y) {
			// 1, 2 사분면 더해줌 					// r 좌표 줄임
			answer = 2 * (quarterOfNumOfZ * 4) + solution(N-1, r-y, c);
		} 
		// 4사분면
		else {
			// 1, 2, 3 사분면 더해줌					// r, c 좌표 줄임
			answer = 3 * (quarterOfNumOfZ * 4) + solution(N-1, r-y, c-x);;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		ZProblem agent = new ZProblem();		
		agent.solution(N, r, c);
		System.out.print(answer);
	}
}
