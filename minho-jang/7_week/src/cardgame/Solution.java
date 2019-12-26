package cardgame;

import java.util.Arrays;

/**
 * ��Ȯ��  �׽�Ʈ
 * �׽�Ʈ 1 ��	��� (5.03ms, 43.6MB)
 * �׽�Ʈ 2 ��	��� (2.31ms, 42.7MB)
 * �׽�Ʈ 3 ��	��� (3.73ms, 43.3MB)
 * �׽�Ʈ 4 ��	��� (7.12ms, 44.2MB)
 * �׽�Ʈ 5 ��	��� (3.00ms, 42.7MB)
 * �׽�Ʈ 6 ��	��� (4.27ms, 43.3MB)
 * �׽�Ʈ 7 ��	��� (3.82ms, 43.7MB)
 * �׽�Ʈ 8 ��	��� (2.99ms, 43.1MB)
 * �׽�Ʈ 9 ��	��� (4.06ms, 42.9MB)
 * �׽�Ʈ 10 ��	��� (5.02ms, 43.7MB)
 * �׽�Ʈ 11 ��	��� (1.53ms, 42.7MB)
 * �׽�Ʈ 12 ��	��� (1.66ms, 42.8MB)
 * �׽�Ʈ 13 ��	��� (4.62ms, 43.7MB)
 * �׽�Ʈ 14 ��	��� (3.14ms, 43.1MB)
 * �׽�Ʈ 15 ��	��� (1.06ms, 42.7MB)
 * 
 * ȿ����  �׽�Ʈ
 * �׽�Ʈ 1 ��	��� (211.38ms, 100MB)
 * �׽�Ʈ 2 ��	��� (111.87ms, 82.6MB)
 * �׽�Ʈ 3 ��	��� (107.93ms, 82.6MB)
 * �׽�Ʈ 4 ��	��� (125.82ms, 88.5MB)
 * �׽�Ʈ 5 ��	��� (90.46ms, 78.9MB)
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
        
        // �ʱ�ȭ
        this.leftCards = left;
        this.rightCards = right;
        visited = new int[left.length][right.length];
        for (int i=0; i < visited.length; i++)
        	Arrays.fill(visited[i], -1);
        
        // ��� ����
        answer = doGame(0, 0);
        
        return answer;
    }
    
    int doGame(int Lidx, int Ridx) {
    	if (Lidx >= leftCards.length || Ridx >= rightCards.length)
    		return 0;
    	
    	// �湮�� �� ������ �Ѿ.
    	if (visited[Lidx][Ridx] != -1)
    		return visited[Lidx][Ridx];
    	
    	int[] results = new int[3];
    	
    	// case 1
    	// ������ ī�尡 ������ �� ī�� �����鼭 ������ ȹ��. (�ε��� �����ϴ°� ������ �Ͱ� ����)
    	if (leftCards[Lidx] > rightCards[Ridx]) 
    		results[0] = doGame(Lidx, Ridx+1) + rightCards[Ridx];
    	
    	// case 2
    	// �������� ���� ī�带 ���� �� �ִ�.
    	results[1] = doGame(Lidx+1, Ridx);
    	
    	// case 3
    	// �������� ���� ī��� ������ ī�带 �� �� ���� �� �ִ�.
    	results[2] = doGame(Lidx+1, Ridx+1);
    	
    	// ������ ���� �ִ밪(������ �ε���) ���ϱ� 
    	Arrays.sort(results);
    	
    	// �湮�� �� �ִ� �� ����. �� ī�� ���¿� ���� ������� �����صд�.
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