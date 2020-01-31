//예산
import java.util.*;

class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int sum=0, i=0;
        Arrays.parallelSort(budgets);
        		//요청 예산 합계
		for(int j=0;j<budgets.length;j++) {
			sum+=budgets[j];	
		}
		
		if(M >= sum) {//예산초과 안했을 경우
			answer=budgets[budgets.length-1];
            return answer;
		}
		
		
        if(budgets[0]>(M/budgets.length)) {
        	answer=M/budgets.length;
        	return answer;
        }
        
        int M2;//임시변수
        	
		for(i=0;i<budgets.length;i++) {
			M-=budgets[i];
			M2=M;
			answer = M2/(budgets.length-(i+1));
			if(answer<=budgets[i+1]) {
				break;
			}
			
		}return answer;
        

    }
}