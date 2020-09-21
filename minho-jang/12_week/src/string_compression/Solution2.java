package string_compression;

import java.util.*;

public class Solution2 {
	public int solution(String s) {

		int minLength = Integer.MAX_VALUE;

		for (int len = 1; len <= s.length() / 2; len++) {
			ArrayList<CompressedString> comStringList = new ArrayList<>();
			StringBuilder sb = new StringBuilder(s);
			int start = 0;

			while (start + len <= s.length()) {
				StringBuilder piece = new StringBuilder(sb.substring(start, start + len));
				if (comStringList.size() == 0) { // 처음 삽입
					comStringList.add(new CompressedString(piece));
				} else {
					// 마지막 요소랑 현재 문자열 조각이랑 같으면
					if (comStringList.get(comStringList.size() - 1).str.toString().equals(piece.toString())) {
						comStringList.get(comStringList.size() - 1).count += 1; // count만 증가
					} else {
						comStringList.add(new CompressedString(piece));
					}
				}
				start += len;
			}

			// 압축 끝나고 남은 문자열 add
			comStringList.add(new CompressedString(new StringBuilder(sb.substring(start))));

			// 길이 검사
			StringBuilder totalString = new StringBuilder();
			for (CompressedString cs : comStringList) {
//				System.out.print(cs.getString() + " ");
				totalString.append(cs.getString());
			}

			System.out.println(" : " + totalString.toString());

			if (minLength > totalString.toString().length())
				minLength = totalString.toString().length();
		}
		
		if (minLength == Integer.MAX_VALUE)
			return 1;

		return minLength;
	}

	class CompressedString {
		int count;
		StringBuilder str;

		CompressedString(StringBuilder str) {
			count = 1;
			this.str = str;
		}

		String getString() {
			if (count == 1)
				return str.toString();
			else {
				return new StringBuilder(String.valueOf(count)).append(str).toString();
			}
		}
	}

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
//		String s = "aabbaccc"; // 7
//    	String s = "ababcdcdababcdcd";		// 9
//    	String s = "abcabcdede";		// 8
//    	String s = "abcabcabcabcdededededede";		// 14
//    	String s = "xababcdcdababcdcd";		// 17
    	String s = "a";

		System.out.println(sol.solution(s));
	}
}
