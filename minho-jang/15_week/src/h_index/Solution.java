package h_index;

/**
 * ��Ȯ�� �׽�Ʈ
 * �׽�Ʈ 1 �� ��� (19.42ms, 52.1MB)
 * �׽�Ʈ 2 �� ��� (28.52ms, 52.4MB)
 * �׽�Ʈ 3 �� ��� (26.29ms, 50.5MB)
 * �׽�Ʈ 4 �� ��� (23.51ms, 50.6MB)
 * �׽�Ʈ 5 �� ��� (29.93ms, 50.6MB)
 * �׽�Ʈ 6 �� ��� (33.23ms, 52.2MB)
 * �׽�Ʈ 7 �� ��� (9.89ms, 54.3MB)
 * �׽�Ʈ 8 �� ��� (6.38ms, 50.7MB)
 * �׽�Ʈ 9 �� ��� (7.13ms, 52.5MB)
 * �׽�Ʈ 10 �� ��� (15.89ms, 52.5MB)
 * �׽�Ʈ 11 �� ��� (36.21ms, 54.3MB)
 * �׽�Ʈ 12 �� ��� (7.33ms, 52.2MB)
 * �׽�Ʈ 13 �� ��� (32.24ms, 52.7MB)
 * �׽�Ʈ 14 �� ��� (30.23ms, 50.6MB)
 * �׽�Ʈ 15 �� ��� (33.66ms, 50.1MB)
 * �׽�Ʈ 16 �� ��� (2.68ms, 51.7MB)
 * 
 * @author Minho
 *
 */
class Solution {
	public int solution(int[] citations) {
		int max = 0;

		for (int h = 0; h < 10000; h++) { // h �ε��� �ĺ� h
			int paperCount = 0;
			for (int c : citations) {
				if (c >= h)
					paperCount++;
			}

			if (paperCount >= h) {
				// h-index �̱� ������ �ִ밪�� ã�ƾ���
				if (max < h)
					max = h;
			}
		}

		return max;
	}

	public static void main(String args[]) {
		Solution s = new Solution();

		int[] citations = { 3, 0, 6, 1, 5 };

		System.out.println(s.solution(citations));
	}
}
