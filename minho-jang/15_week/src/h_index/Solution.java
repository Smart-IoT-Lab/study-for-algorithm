package h_index;

/**
 * 정확성 테스트
 * 테스트 1 〉 통과 (19.42ms, 52.1MB)
 * 테스트 2 〉 통과 (28.52ms, 52.4MB)
 * 테스트 3 〉 통과 (26.29ms, 50.5MB)
 * 테스트 4 〉 통과 (23.51ms, 50.6MB)
 * 테스트 5 〉 통과 (29.93ms, 50.6MB)
 * 테스트 6 〉 통과 (33.23ms, 52.2MB)
 * 테스트 7 〉 통과 (9.89ms, 54.3MB)
 * 테스트 8 〉 통과 (6.38ms, 50.7MB)
 * 테스트 9 〉 통과 (7.13ms, 52.5MB)
 * 테스트 10 〉 통과 (15.89ms, 52.5MB)
 * 테스트 11 〉 통과 (36.21ms, 54.3MB)
 * 테스트 12 〉 통과 (7.33ms, 52.2MB)
 * 테스트 13 〉 통과 (32.24ms, 52.7MB)
 * 테스트 14 〉 통과 (30.23ms, 50.6MB)
 * 테스트 15 〉 통과 (33.66ms, 50.1MB)
 * 테스트 16 〉 통과 (2.68ms, 51.7MB)
 * 
 * @author Minho
 *
 */
class Solution {
	public int solution(int[] citations) {
		int max = 0;

		for (int h = 0; h < 10000; h++) { // h 인덱스 후보 h
			int paperCount = 0;
			for (int c : citations) {
				if (c >= h)
					paperCount++;
			}

			if (paperCount >= h) {
				// h-index 이긴 하지만 최대값을 찾아야해
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
