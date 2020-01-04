package baekjoon_11053;
//가장 긴 증가하는 부분 수열

import java.util.*;

public class Main2 {

//	public static void main(String[] args) {
//		
//		Scanner scanner = new Scanner(System.in);
//		int size = scanner.nextInt();
//		int[] arr = new int[size];
//		for (int i=0; i<size; i++)
//			arr[i] = scanner.nextInt();
//		
//		int[] dp = new int[size];
//		Arrays.fill(dp, 1);
//		
//		for (int i=1; i<size; i++) {
//			for (int j=0; j<i; j++) {
//				
//				if (arr[i] > arr[j])
//					dp[i] = Math.max(dp[j] + 1, dp[i]);
//			}
//		}
//		
//		Arrays.sort(dp);
//		System.out.println(dp[size-1]);
//	}
}
