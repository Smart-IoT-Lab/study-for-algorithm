package algorithmStudy.week1;

public class BaseBallAgent {
	public int solution(int[][] question) {
		int answer = 0;
		
		for(int i = 123; i <= 987; i++)
		{
			int a, b, c;
			a = i / 100;
			b = (i / 10) % 10;
			c = i % 10;
			// System.out.println(a+""+b+""+c);
			
			if(a == b || b == c || c == a || b == 0 || c == 0) 
				continue;
			
			if(a == '0' || b == '0' || c == '0')
				System.out.println("error");
			
			int currentStrike, currentBall;
			
			for(int idx = 0; idx < question.length; idx ++)
			{
				// [idx][0] = 3자리 숫자
				// [idx][1] = 스트라이크
				// [idx][2] = 볼
				currentStrike = 0;
				currentBall = 0;
				
				int question0, question1, question2;
				int answerStrike, answerBall;
				
				int questionNum = question[idx][0];
				
				question0 = questionNum / 100;
				question1 = (questionNum / 10) % 10;
				question2 = questionNum % 10;
				
				answerStrike = question[idx][1];
				answerBall = question[idx][2];
				
				// 자리와 숫자 일치하면 currentStrike 카운트 증가
				if (a == question0)
					currentStrike += 1;
				if (b == question1)
					currentStrike += 1;
				if (c == question2)
					currentStrike += 1;
				
				// 스트라이크 일치 안하면 나감
				if (currentStrike != answerStrike)
					break;
				
				// 자리는 다르고 숫자 같다면 currentBall 카운트 증가
				if (a != question0 && a == question1 || a == question2)
					currentBall += 1;
				if (b != question1 && b == question0 || b == question2)
					currentBall += 1;
				if (c != question2 && c == question0 || c == question1)
					currentBall += 1;
				
				// 볼 일치 안하면 나감
				// 스트라이크 일치 안하면 나감
				if (currentBall != answerBall)
					break;
				
				// 모든 질문에 통과하면 가능한 경우 +1
				if (idx == (question.length-1))
					answer += 1;
				// System.out.println(question0+""+question1+""+question2);
			}
		}
		System.out.println(answer);
		return answer;
	}
}
