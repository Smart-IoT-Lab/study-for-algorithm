package algorithmStudy.week4;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class NExpress {
	static int CALCULATION_LIMIT = 9;
	static ArrayList<Set<Integer>> useNPossibleNumber = 
			new ArrayList<Set<Integer>>(CALCULATION_LIMIT);
	
	int answer = -1;
	public int solution(int N, int number) {
		UseNCalculation(N, 1, number);
		System.out.println(answer);
		return answer;
	}

	public void UseNCalculation(int N, int useN, int number) {

		Set<Integer> useNCalcResult = new HashSet<Integer>();
		if(useN > 8) {
			answer = -1;
			return;
		}
		if(useN == 1) {
			// index 0 처리
			useNPossibleNumber.add(new HashSet<Integer>(0));
			useNCalcResult.add(0 + N);
			useNCalcResult.add(0 - N);
		} else {
			int temp = 0;
			for(int i = 0; i < useN; i++) {
				temp = temp*10 + N;
				System.out.println("useN :" + useN+ " temp :" + temp);
			}
			// n개 나열해서 나타낼수 있는 숫자 : ex 2개 나열 55
			useNCalcResult.add(temp);
			
			// N을 한개 덜 쓴 경우와 사칙연산 해줌
			for (Integer num : useNPossibleNumber.get(useN-1)) {
				System.out.println("useN - 1 :" + (useN - 1) + " num :"+num);
				System.out.println("num + N: "+(num + N));
				System.out.println("num - N: "+(num - N));
				System.out.println("num * N: "+(num * N));
				System.out.println("num / N: "+(num / N));
				
				useNCalcResult.add(num + N);
				useNCalcResult.add(num - N);
				useNCalcResult.add(num * N);
				useNCalcResult.add(num / N);
			}
		}
		
		if(useNCalcResult.contains(number)) {
			answer = useN;
			return;
		} else {
			useNPossibleNumber.add(useNCalcResult);
			UseNCalculation(N, useN + 1, number);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NExpress nExpressAgent = new NExpress();
		System.out.println("expected answer 4");
		nExpressAgent.solution(5, 12);
	}

}
