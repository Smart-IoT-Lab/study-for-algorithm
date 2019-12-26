package cardgame;

import java.util.Arrays;

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (5.03ms, 43.6MB)
 * 테스트 2 〉	통과 (2.31ms, 42.7MB)
 * 테스트 3 〉	통과 (3.73ms, 43.3MB)
 * 테스트 4 〉	통과 (7.12ms, 44.2MB)
 * 테스트 5 〉	통과 (3.00ms, 42.7MB)
 * 테스트 6 〉	통과 (4.27ms, 43.3MB)
 * 테스트 7 〉	통과 (3.82ms, 43.7MB)
 * 테스트 8 〉	통과 (2.99ms, 43.1MB)
 * 테스트 9 〉	통과 (4.06ms, 42.9MB)
 * 테스트 10 〉	통과 (5.02ms, 43.7MB)
 * 테스트 11 〉	통과 (1.53ms, 42.7MB)
 * 테스트 12 〉	통과 (1.66ms, 42.8MB)
 * 테스트 13 〉	통과 (4.62ms, 43.7MB)
 * 테스트 14 〉	통과 (3.14ms, 43.1MB)
 * 테스트 15 〉	통과 (1.06ms, 42.7MB)
 * 
 * 효율성  테스트
 * 테스트 1 〉	통과 (211.38ms, 100MB)
 * 테스트 2 〉	통과 (111.87ms, 82.6MB)
 * 테스트 3 〉	통과 (107.93ms, 82.6MB)
 * 테스트 4 〉	통과 (125.82ms, 88.5MB)
 * 테스트 5 〉	통과 (90.46ms, 78.9MB)
 * 
 * @author Minho
 *
 */
class Solution {
	int[] leftCards;
	int[] rightCards;
	
	int[][] visited;
	int count = 0;
	
    public int solution(int[] left, int[] right) {
        int answer = 0;
        
        // 초기화
        this.leftCards = left;
        this.rightCards = right;
        visited = new int[left.length][right.length];
        for (int i=0; i < visited.length; i++)
        	Arrays.fill(visited[i], -1);
        
        // 재귀 시작
        answer = doGame(0, 0);
        
        return answer;
    }
    
    int doGame(int Lidx, int Ridx) {
    	if (Lidx >= leftCards.length || Ridx >= rightCards.length)
    		return 0;
    	
    	// 방문한 적 있으면 넘어가.
    	if (visited[Lidx][Ridx] != -1)
    		return visited[Lidx][Ridx];
    	
    	int[] results = new int[3];
    	
    	// case 1
    	// 오른쪽 카드가 작으면 그 카드 버리면서 점수를 획득. (인덱스 증가하는게 버리는 것과 같다)
    	if (leftCards[Lidx] > rightCards[Ridx]) 
    		results[0] = doGame(Lidx, Ridx+1) + rightCards[Ridx];
    	
    	// case 2
    	// 언제든지 왼쪽 카드를 버릴 수 있다.
    	results[1] = doGame(Lidx+1, Ridx);
    	
    	// case 3
    	// 언제든지 왼쪽 카드와 오른족 카드를 둘 다 버릴 수 있다.
    	results[2] = doGame(Lidx+1, Ridx+1);
    	
    	// 정렬을 통해 최대값(마지막 인덱스) 구하기 
    	Arrays.sort(results);
    	
    	// 방문한 적 있던 곳 저장. 현 카드 상태에 대한 결과값을 저장해둔다.
    	visited[Lidx][Ridx] = results[results.length-1];
    	
    	return results[results.length-1];
    }
    
    public static void main(String args[]) {
    	Solution s = new Solution();
    	int[] left = {3,2,1,6};
    	int[] right = {2,4,7,5};
    	
    	System.out.println(s.solution(left, right));
    	System.out.println(s.count);
    }
}