package word_change;
// DFS

import java.util.*;

public class Solution {

	public int solution(String begin, String target, String[] words) {
		int answer = 0;

		if (arrayToList(words).contains(target)) // ���ԵǾ��־�� ã�� ����
			answer = dfs(begin, target, words);

		return answer;
	}

	int dfs(String begin, String target, String[] words) {
		if (begin.equals(target)) // �������. ������ ���� 0
			return 0;

		ArrayList<String> wordsList = arrayToList(words);
		int result = -1;

		for (String w : words) {
			if (compareS(begin, w)) { 	// words �߿��� �� ���� Ʋ�� �ܾ ã��
				wordsList.remove(w); 	// ã�� �ܾ�� ����Ʈ���� ����(��湮 ����)
				// �� ���� �ٸ� �ܾ���� �����ؼ� dfs ���
				result = dfs(w, target, wordsList.toArray(new String[wordsList.size()])) + 1;
			}
		}

		if (result < 0) 	// words�� ���ų�(empty), �ܾ ã�� ���ϸ� 0�� ����
			return 0;

		return result;
	}

	boolean compareS(String s1, String s2) { // �� �� �����ΰ�?
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
	 * �ݷ� ����... 
	 * String begin = "hit"
	 * String target = "wow"
	 * String[] words = {"hot", "dot", "dog", "lot", "log", "cog", "wow" }
	 * "wow" �ܾ ���������� "wow"�� ���� ���� �������� �ʴ´�.
	 * �̷� ��Ȳ�� ���� �������� �� ������ ����. ������� �ʴ� ���� �ε�
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