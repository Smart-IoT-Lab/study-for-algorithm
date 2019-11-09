public class NumberBaseball {
	
	public int solution(int[][] baseball) {
		int answer = 0;
		for(int number=123; number<=987; number++) {
			int hundred = number / 100;
			int ten = (number % 100) / 10;
			int one = number % 10;
			boolean[] conditionCheck = new boolean[baseball.length];
			int allCheck = 0;
			
			if((ten == 0) || (one == 0)) continue;
			if((hundred == ten) || (hundred == one) || (ten == one)) continue;
			//System.out.println("Number: "+ number);
			
			for(int i=0; i<baseball.length; i++) {
				// 비교할 수의 백의 자리, 십의 자리, 일의 자리수
				int gHundred = baseball[i][0] / 100;
				int gTen = (baseball[i][0] % 100) / 10;
				int gOne = baseball[i][0] % 10;
				
				//System.out.println("gHundred : "+gHundred + "\tgTen : "+gTen + "\tgOne: "+gOne);
				
				int strike = 0;
				int ball = 0;
				
				if(hundred == gHundred) strike += 1;
				if((hundred == gTen) || (hundred == gOne)) ball +=1;
				
				if(ten == gTen) strike += 1;
				if((ten == gHundred) || (ten == gOne)) ball +=1;
				
				if(one == gOne) strike += 1;
				if((one == gHundred) || (one == gTen)) ball +=1;
				
				if((strike == baseball[i][1]) && (ball == baseball[i][2])) conditionCheck[i] = true;
				else conditionCheck[i] = false;
				
				//System.out.println("s: " + strike + "\tb: "+ball);
			}
			
			for(boolean check : conditionCheck) {
				if(check == true) allCheck +=1;
			}
			if(allCheck == baseball.length) answer += 1;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int [][] baseball = {
				{123, 1, 1},
				{356, 1, 0}, 
				{327, 2, 0}, 
				{489, 0, 1}
				};
		
		NumberBaseball nb = new NumberBaseball();
		int answer = nb.solution(baseball);
		System.out.println("#result : " + answer);
	}
}
