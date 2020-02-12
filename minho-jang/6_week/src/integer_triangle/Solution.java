package integer_triangle;

public class Solution {
	/**
	 * 아래층 부터 최대값을 찾으면서 삼각형을 만든다.
	 * 삼각형 전체를 만드는 것이 아니라
	 * 삼각형을 만들면서 필요한 값들만 배열에 저장하면서 for문으로 반복한다.
	 * 
	 * @param triangle 정수삼각형
	 * @return 경로가 가지는 최대값
	 */
	public int solution(int[][] triangle) {
        int bottomIndex = triangle.length-1;
        
        int maxLength = triangle[bottomIndex].length;
        int[] parentsInteger = new int[maxLength];	// 현재 계산하고 있는 층
        int[] childsInteger = new int[maxLength];	// 현재 층 계산에서 이용될 밑의 층
        
        for (int floor = bottomIndex; floor >= 0; floor--) {
        	// 맨 밑층이면
        	if (floor == bottomIndex)
        		parentsInteger = triangle[bottomIndex];
        	// 맨 밑바닥이 아니면
        	else {
        		// 계산된 parents는 자식으로 내려가고
        		childsInteger = parentsInteger;
        		//			층 수가 해당 층의 숫자 개수	
        		for (int i=0; i <= floor; i++) {
        			// 현재 가질수있는 최대값			본인			+		아래 자식 중 최대값
            		parentsInteger[i] = triangle[floor][i] + Math.max(childsInteger[i], childsInteger[i+1]);
        		}
        	}
        }
        
        return parentsInteger[0];
    }
	
	public static void main(String args[]) {
		Solution s = new Solution();
		
		int[][] triangle = {
				{7},
				{3,8},
				{8,1,0},
				{2,7,4,4},
				{4,5,2,6,5}
		};
		
		System.out.println(s.solution(triangle));
	}
}