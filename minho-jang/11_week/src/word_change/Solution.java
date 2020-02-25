package word_change;
// DFS

import java.util.*;

public class Solution {

	public int solution(String begin, String target, String[] words) {
		int answer = 0;

		if (arrayToList(words).contains(target)) // 포함되어있어야 찾기 시작
			answer = dfs(begin, target, words);

		return answer;
	}

	int dfs(String begin, String target, String[] words) {
		if (begin.equals(target)) // 기저사례. 같으면 리턴 0
			return 0;

		ArrayList<String> wordsList = arrayToList(words);
		int result = -1;

		for (String w : words) {
			if (compareS(begin, w)) { 	// words 중에서 한 끗만 틀린 단어를 찾아
				wordsList.remove(w); 	// 찾은 단어는 리스트에서 제외(재방문 방지)
				// 한 끗만 다른 단어들을 선택해서 dfs 재귀
				result = dfs(w, target, wordsList.toArray(new String[wordsList.size()])) + 1;
			}
		}

		if (result < 0) 	// words가 없거나(empty), 단어를 찾지 못하면 0이 리턴
			return 0;

		return result;
	}

	boolean compareS(String s1, String s2) { // 한 끗 차이인가?
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		int falseCount = 0;

		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != c2[i])
				falseCount++;

			if (falseCount > 1)
				return false;
		}

		if (falseCount == 0)
			return false;

		return true;
	}

	ArrayList<String> arrayToList(String[] arr) {
		ArrayList<String> list = new ArrayList<>();
		for (String s : arr)
			list.add(s);

		return list;
	}

	/**
	 * 반례 존재... 
	 * String begin = "hit"
	 * String target = "wow"
	 * String[] words = {"hot", "dot", "dog", "lot", "log", "cog", "wow" }
	 * "wow" 단어가 존재하지만 "wow"로 가는 길은 존재하지 않는다.
	 * 이런 상황에 대한 제한조건 및 설명이 없다. 고려하지 않는 예시 인듯
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog"};
		// String[] words = {"hot", "dot", "dog", "lot", "log"};

		System.out.println(s.solution(begin, target, words));
	}
}