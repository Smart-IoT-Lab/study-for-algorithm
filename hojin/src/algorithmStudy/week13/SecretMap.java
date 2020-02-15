package algorithmStudy.week13;

import java.util.Arrays;

public class SecretMap {

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
//		if (n == 1)
//		{
//			if(arr1[0] == 0 && arr2[0] == 0) {
//				answer[0] = " ";
//			}
//			// 아니면 #
//			else {
//				answer[0] = "#";
//			}
//		}
		String[] strBinary1 = new String[n];
		String[] strBinary2 = new String[n];
		
		String formatting = "%0" + Integer.toString(n) + "d";
		
		for(int i = 0; i < n; i++) {
			strBinary1[i] = String.format(formatting, Integer.parseInt(Integer.toBinaryString(arr1[i]).toString()));
			strBinary2[i] = String.format(formatting, Integer.parseInt(Integer.toBinaryString(arr2[i]).toString()));
		}
		
		System.out.println(strBinary1[0]);
		System.out.println(strBinary1[0].charAt(0));
		
		byte zero = '0';
		byte one = '1';
		
		for(int i = 0; i <n; i++) {
			String decodingLine = "";
			for(int j = 0; j < n; j++) {
				// 둘 다 0이면 공백
				if(strBinary1[i].charAt(j) == zero && strBinary2[i].charAt(j) == zero) {
					decodingLine = decodingLine + " ";
				}
				// 아니면 #
				else {
					decodingLine = decodingLine + "#";
				}
			}
			answer[i] = decodingLine;
		}
		//System.out.println(Arrays.toString(answer));
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecretMap agent = new SecretMap();
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
//		System.out.println("expected");
//		System.out.println("#####");
//		System.out.println("# # #");
//		System.out.println("### #");
//		System.out.println("# ##");
//		System.out.println("#####");
		agent.solution(n, arr1, arr2);
	}

}
