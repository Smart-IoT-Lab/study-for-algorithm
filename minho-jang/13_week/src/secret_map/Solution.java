package secret_map;

import java.util.*;

class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		for (int i=0; i<n; i++) {
			StringBuilder sb = new StringBuilder();
			StringBuilder result = new StringBuilder(Integer.toBinaryString(arr1[i] | arr2[i]));
			while(result.length() < n) 
				result.insert(0, '0');
			
			for (char c : result.toString().toCharArray()) {
				if (c == '1')
					sb.append('#');
				else
					sb.append(' ');
			}
			answer[i] = sb.toString();
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
//		int n = 5;
//		int[] arr1 = {9,20,28,18,11};
//		int[] arr2 = {30,1,21,17,28};
		int n = 6;
		int[] arr1 = {46,33,33,22,31,50};
		int[] arr2 = {27,56,19,14,14,10};
		
		String[] answer = s.solution(n, arr1, arr2);
		for (String str : answer) 
			System.out.println(str);
		
	}
}