package budget;

public class Solution {
	public int solution(int[] budgets, int M) {
        long sum = 0;		// long 형으로 안바꿔주면 테스트케이스 2번이 실패한다. 합을 구하면서 int형의 범위를 초과한 듯 하다.
        
        // 1 ~ (budgets의 최대값) 사이의 값 중 이분탐색을 통해 상한선을 찾자.
        int left = 1;			// 1이 왼쪽
        int right = 0;
        for (int i : budgets) {
        	sum += i;			// budgets의 합도 같이 구하자. 
        	if (right < i)
        		right = i;		// budgets의 최대값이 오른쪽
        }
        
        // 상한선 없이 배정 가능
        if (sum <= M)
        	return right;		// 상한선이 없어도 되면 최대값을 리턴해야 하더라..
        
        // 상한선 구하자
        while(true) {
        	int sub = right-left;
        	if (sub == 0)
        		return left;
        	else if (sub == 1) {
        		int checkRight = checkSum(right, budgets, M);
        		if (checkRight > -1)	// 0 또는 1 을 리턴하면 right가 최대 상한선
        			return right;
        		else 
        			return left;
        	}
        	
        	int center = (left+right) / 2;
        	int check = checkSum(center, budgets, M);
        	if (check == 1) {		// 상한선이 커져야해
        		left = center;
        	} else if (check == -1) {		// 상한선이 작아져야해
        		right = center;
        	} else {
        		break;
        	}
        }
        
        return left;
    }
	
	private int checkSum(int upperLimit, int[] budgets, int M) {
		int sum = 0;
		for(int i=0; i<budgets.length; i++) {
			if (budgets[i] > upperLimit) 
				sum += upperLimit;
			else 
				sum += budgets[i];
		}
		
		// M 으로 할당 가능하면 1, 초과하면 -1, 같으면 0
		if (sum < M)
			return 1;
		else if (sum > M)
			return -1;
		else
			return 0;
	}

	public static void main(String[] agrs) {
		Solution s = new Solution();
		int[] budgets = {120,110,140,150};
		int M = 485;
//		int[] budgets = {9,8,5,6,7};
//		int M = 5;
		
		System.out.println(s.solution(budgets, M));
		
	}
}
