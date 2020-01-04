package baekjoon_11053;
// 가장 긴 증가하는 부분 수열

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	int[] memo;
	int size;
	int[] input;
	
	int solution(int size, int[] input) {
		int answer = 0;
		
		///////// 초기화
		this.size = size;
		this.input = input;
		
		memo = new int[size];
		Arrays.fill(memo, 1);
		/////////////////
		
		int max = 0;
		int n;
		// 각각의 인덱스를 시작으로 선택 가능하므로 인덱스 별로 nextBigger를 호출하지만
		// memo에 있다면 nextBigger를 호출하지 않는다.
		for (int i=0; i<size; i++) {
			if (memo[i] != 1)
				n = memo[i];
			else
				n = nextBigger(i);
			
			// 각 인덱스 선택한 값 중 가장 큰 값을 저장
			if (max < n)
				max = n;
		}
		
		// memo에 저장되는 값 확인
		for(int i : memo)
			System.out.print(i + " ");
		System.out.println();
		
		answer = max;
		return answer;
	}
	
	// 현재 인덱스에서 뒤에 나오는 LIS의 길이 최대값을 리턴
	int nextBigger(int index) {
		int length = 1;
		int maxLength = length;
		
		// 이미 계산된 값은 넘어가
		if (memo[index] != 1)
			return memo[index];
		
		for (int i=index+1; i<size; i++) {
			// 현재 인덱스로부터 뒤에 선택가능한 요소가 있다면 재귀호출. 길이증가(+1)
			if (input[index] < input[i])
				length = nextBigger(i)+1;
			
			// 선택가능한 요소 중에서 리턴된 값 중 길이가 긴 값을 저장.
			if (maxLength < length)
				maxLength = length;
		}
		
		// 해당 인덱스에 대한 값을 저장
		if (memo[index] == 1)
			memo[index] = maxLength;
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] input = new int[size];
		for (int i=0; i<size; i++)
			input[i] = scanner.nextInt();
		
		System.out.println(m.solution(size, input));
	}
}
