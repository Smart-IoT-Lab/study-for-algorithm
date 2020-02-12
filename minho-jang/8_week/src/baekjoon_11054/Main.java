package baekjoon_11054;
// ���� �� ������� �κм���

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		////// �ʱ�ȭ �� �Է�
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] arr = new int[size];
		for (int i=0; i<size; i++)
			arr[i] = scanner.nextInt();
		
		int[] dp = new int[size];
		Arrays.fill(dp, 1);
		/////////////////////
		
		// ���� dp ���
		for (int i=1; i<size; i++) {
			for (int j=0; j<i; j++) {
				if (arr[i] > arr[j])
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
		}
		
		// ������ ����� ���� dp���ٰ�
		// ���� dp ����.
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
