package tile_decoratation;

public class Solution {
	/**
	 * 먼저 타일을 구성하는 정사각형 한 변의 길이 = {1, 1, 2, 3, 5, 8 ... }
	 * >> An+1 = An + An-1
	 * 
	 * 다음 큰 직사각형 둘레의 합은 규칙에 따라서
	 * >> Bn+1 = Bn + 2*An
	 * 
	 * 위의 점화식을 이용하여 N번 반복하면 된다.
	 * 
	 * @param N 타일의 개수
	 * @return 직사각형 둘레의 합
	 */
	public long solution(int N) {
		//		An				An+1 < 얘는 현재에선 필요없지만 다음 항을 구할 때 쓰일거야
        long tempSide1 = 1, tempSide2 = 1;
        
        // 직사각형 둘레의 합, 즉 answer.
        long sumSides = 4;
        
        // N=1일 때의 상황으로 초기화 했으므로
        // N-1번 반복한다.
        for (int countTile = 1; countTile < N; countTile++) {
        	long t = tempSide1;
        	tempSide1 = tempSide2;
        	tempSide2 = t + tempSide2;
        	
        	sumSides = sumSides + 2*tempSide1;
        }
        
        return sumSides;
    }
	
	public static void main(String args[]) {
		Solution s = new Solution();
		
		int N = 5;
		System.out.println(s.solution(N));
	}

}

