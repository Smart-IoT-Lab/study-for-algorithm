package algorithmStudy.week1;

import java.lang.Math;

public class DartGame {
	public int solution(String dartResult) 
	{
	      int answer = 0;
	      
	      int currentScore = 0;
	      int preScore = 0;
	      
	      for(int i = 0; i < dartResult.length(); i++)
	      {
	    	  int currentCh = (int)dartResult.charAt(i);
	    	  
	    	  // 숫자 처리
	    	  // 숫자 문자 넣으면 아스키로 비교함
	    	  // 48~57 : '0'~'9'
	    	  if (('0' <= currentCh) && (currentCh <= '9'))
	    	  {
	    		  // 현재 문자가 0, 첫번째 문자열이 아니고 이전 문자가 1 인 경우 10 
	    		  if ((currentCh == '0') && (i != 0) && (dartResult.charAt(i-1) == '1'))
	    		  {
	    			  currentScore = 10;
	    		  }
	    		  // 숫자를 만났을때만 이전 스코어를 업데이트 하고 답에 더해줌
	    		  // 1다음 0이 왔을때에는 이전 Score를 업데이트 하지 않음
	    		  else
	    		  {
	    			  System.out.println("in num currentScore : "+currentScore);
	    			  preScore = currentScore;
	    			  answer += preScore;
	    			  System.out.println("in num answer : "+answer);
	    			// 0의 아스키 코드 값이 48  이므로 48로 나눠서 숫자 변환
	    			  currentScore = currentCh % 48;
	    		  }

	    	  }
	    	  // 보너스 처리
	    	  else if (currentCh == 'S')
	    		  currentScore = (int) Math.pow(currentScore, 1);  
	    	 
	    	  else if (currentCh == 'D')
	    		  currentScore = (int) Math.pow(currentScore, 2);
	    		  
	    	  else if (currentCh == 'T')
	    		  currentScore = (int) Math.pow(currentScore, 3);
	    	  
	    	  // 옵션 처리
	    	  // 현재 값은 두배로 하고 이전 값은 한번 더 더해줌
	    	  // answer에는 이전 값을 저장 해놨기 때문
	    	  else if (currentCh == '*')
	    	  {
	    		  currentScore = currentScore * 2;
	    		  // preScore = preScore * 2;
	    		  answer += preScore;
	    	  }
	    	  else if (currentCh == '#')
	    		  currentScore = (-1) * currentScore;
	    	  // 모든 문자열 처리 끝나면 현재 스코어 합산
	    	  if (i == (dartResult.length()-1))
	    		  answer += currentScore;
	      }
	      System.out.println(answer);
	      
	      return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dartResult = "1D2S0T";
		DartGame dart = new DartGame();
		System.out.println("3");
		dart.solution(dartResult);
	}

}
