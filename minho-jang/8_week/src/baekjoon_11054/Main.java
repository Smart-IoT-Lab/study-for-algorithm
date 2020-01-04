package baekjoon_11054;
// 가장 긴 바이토닉 부분수열

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		////// 초기화 및 입력
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] arr = new int[size];
		for (int i=0; i<size; i++)
			arr[i] = scanner.nextInt();
		
		int[] dp = new int[size];
		Arrays.fill(dp, 1);
		/////////////////////
		
		// 증가 dp 계산
		for (int i=1; i<size; i++) {
			for (int j=0; j<i; j++) {
				if (arr[i] > arr[j])
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
		}
		
		// 위에서 계산한 증가 dp에다가
		// 감소 dp 누적.
		for (int i=1; i<size; i++) {
			for (int j=0; j<i; j++) {
				if (arr[i] < arr[j]) 
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
		}

		for(int i : dp)
			System.out.print(i + " ");
		System.out.println();
		
		Arrays.sort(dp);
		System.out.println(dp[size-1]);
	}
}
