package target_number;

/**
 * ��Ȯ��  �׽�Ʈ
 * �׽�Ʈ 1 ��	��� (8.35ms, 52.5MB)
 * �׽�Ʈ 2 ��	��� (7.87ms, 52.4MB)
 * �׽�Ʈ 3 ��	��� (1.07ms, 50.2MB)
 * �׽�Ʈ 4 ��	��� (1.47ms, 51.9MB)
 * �׽�Ʈ 5 ��	��� (1.84ms, 52.3MB)
 * �׽�Ʈ 6 ��	��� (1.20ms, 53MB)
 * �׽�Ʈ 7 ��	��� (1.01ms, 52.2MB)
 * �׽�Ʈ 8 ��	��� (1.51ms, 52MB)
 * @author Minho
 *
 */
class Solution {
    int[] numbers;
    int target;
    int answerCount = 0;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, numbers[0]);
        dfs(0, numbers[0]*(-1));
        
        return answerCount;
    }
    
    void dfs(int depth, int number) {
        // System.out.println("current depth: " + depth);
        if (depth == numbers.length-1) {  // ��� �׸�
            if (number == target) 
                answerCount++;
            return;
        }
        
        dfs(depth+1, number + numbers[depth+1]);
        dfs(depth+1, number + numbers[depth+1]*(-1));
    }
    
    public static void main(String args[]) {
    	Solution s = new Solution();
    	
    	int[] numbers = {1,1,1,1,1};
    	int target = 3;
    	
    	System.out.println(s.solution(numbers, target));
    }
}
