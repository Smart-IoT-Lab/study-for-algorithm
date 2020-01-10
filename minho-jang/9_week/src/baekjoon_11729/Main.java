package baekjoon_11729;
// 하노이 탑 이동 순서

import java.util.*;

public class Main {
	static int count = 0;
	// StringBuilder 대신 매 순간 System.out.println()을 실행하니 시간초과가 난다.
	static StringBuilder sb;
	
	// A 타워의 어떤 밑바닥 원반 bottom을 C 타워로 옮겨야 할 때,
	// A 타워의 원반 bottom 위에 있는 원반들을 다른 B 타워로 모두 옮겨야 한다.
	public static void main(String[] args) {
		/////////// 입력 및 초기화
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		sb = new StringBuilder();
		/////////////////////////////
		
		moveDisc(N, 1, 2, 3);
		System.out.println(count);
		System.out.println(sb);
	}
	
	static void moveDisc(int target, int from, int tmp, int to) {
		count++;
		
		// 기저사례
		if (target == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}
			
		moveDisc(target-1, from, to, tmp);
		sb.append(from + " " + to + "\n");
		moveDisc(target-1, tmp, from, to);
	}
}
