package string_;

import java.util.ArrayList;

class Solution {
	public int solution(String dartResult) {
		int answer = 0;
		int idx = 0;
		ArrayList<Score> score = new ArrayList<>();
		
		while(true) {
			char c = dartResult.charAt(idx);
			
			// 1S2D3T
			if (c == ����) {
				boolean inLoop = true;
				Score s = new Score();
				s.num.concat(String.valueOf(c));

				while(inLoop) {
					if (c == ����)
						s.num.concat(String.valueOf(c));

					if (c == ���)
						s.times = c;
					
					if (c == �ɼ�)
						s.option = c;
				}
				
				score.add(s);
				idx++;
			}
			
			
			
			if (idx == dartResult.length())
				break;
			
			idx++;
		}
		
		return answer;
	}
	
	class Score {
		String num;
		char times;
		char option;
		
		Score(){
			num = "";
			times = '\0';
			option = '\0';
		}
		
		Score(String num, char times, char option) {
			this.num = num;
			this.times = times;
			this.option = option;
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		sol.solution("1S2D3T");
	}
	
	
}