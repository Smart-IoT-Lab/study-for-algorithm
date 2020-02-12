package baekjoon_1074;
// Z (다른 풀이)
// 기본적인 방식이 시간초과가 나므로 인터넷에서 찾은 다른 방식

import java.util.Scanner;

public class Main2 {
	static int row;
	static int column;
	static int count = 0;
	
	public static void main(String[] args) {
		//////////////////입력 및 초기화
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		row = scanner.nextInt();
		column = scanner.nextInt();
		///////////////////////////////
		
		searchPos(N);
		System.out.println(count);
	}
	
	// 4등분 한 사각형 중 어느 사각형에 속하는가
	static void searchPos(int N) {
		int size = (int) Math.pow(2, N);
		
		if(size == 1) 
			return;
		
		// 1 사분면
		if (0 <= row && row < (size/2) &&
				0 <= column && column < (size/2)) {
			count += 0 * (int) Math.pow(4, N-1);
		}
		
		// 2 사분면
		else if (0 <= row && row < (size/2) &&
				(size/2) <= column && column < size) {
			count += 1 * (int) Math.pow(4, N-1);
			column = column - size/2;
		}
		
		// 3 사분면
		else if ((size/2) <= row && row < size &&
				0 <= column && column < (size/2)) {
			count += 2 * (int) Math.pow(4, N-1);
			row = row - size/2;
		}
		
		// 4 사분면
		else if ((size/2) <= row && row < size &&
				(size/2) <= column && column < size) {
			count += 3 * (int) Math.pow(4, N-1);
			row = row - size/2;
			column = column - size/2;
		}
		
		searchPos(N-1);
	}
}
