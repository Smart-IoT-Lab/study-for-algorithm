package target_number;

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (8.35ms, 52.5MB)
 * 테스트 2 〉	통과 (7.87ms, 52.4MB)
 * 테스트 3 〉	통과 (1.07ms, 50.2MB)
 * 테스트 4 〉	통과 (1.47ms, 51.9MB)
 * 테스트 5 〉	통과 (1.84ms, 52.3MB)
 * 테스트 6 〉	통과 (1.20ms, 53MB)
 * 테스트 7 〉	통과 (1.01ms, 52.2MB)
 * 테스트 8 〉	통과 (1.51ms, 52MB)
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
        if (depth == numbers.length-1) {  // 재귀 그만
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
