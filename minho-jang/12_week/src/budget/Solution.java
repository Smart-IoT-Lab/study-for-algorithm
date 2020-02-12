package budget;

public class Solution {
	public int solution(int[] budgets, int M) {
        long sum = 0;		// long ������ �ȹٲ��ָ� �׽�Ʈ���̽� 2���� �����Ѵ�. ���� ���ϸ鼭 int���� ������ �ʰ��� �� �ϴ�.
        
        // 1 ~ (budgets�� �ִ밪) ������ �� �� �̺�Ž���� ���� ���Ѽ��� ã��.
        int left = 1;			// 1�� ����
        int right = 0;
        for (int i : budgets) {
        	sum += i;			// budgets�� �յ� ���� ������. 
        	if (right < i)
        		right = i;		// budgets�� �ִ밪�� ������
        }
        
        // ���Ѽ� ���� ���� ����
        if (sum <= M)
        	return right;		// ���Ѽ��� ��� �Ǹ� �ִ밪�� �����ؾ� �ϴ���..
        
        // ���Ѽ� ������
        while(true) {
        	int sub = right-left;
        	if (sub == 0)
        		return left;
        	else if (sub == 1) {
        		int checkRight = checkSum(right, budgets, M);
        		if (checkRight > -1)	// 0 �Ǵ� 1 �� �����ϸ� right�� �ִ� ���Ѽ�
        			return right;
        		else 
        			return left;
        	}
        	
        	int center = (left+right) / 2;
        	int check = checkSum(center, budgets, M);
        	if (check == 1) {		// ���Ѽ��� Ŀ������
        		left = center;
        	} else if (check == -1) {		// ���Ѽ��� �۾�������
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
		
		// M ���� �Ҵ� �����ϸ� 1, �ʰ��ϸ� -1, ������ 0
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
