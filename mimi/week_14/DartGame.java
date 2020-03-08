import java.util.*;

public class DartGame {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		테스트 1 〉	통과 (0.92ms, 52.4MB)
//		테스트 2 〉	통과 (0.77ms, 52MB)
//		테스트 3 〉	실패 (1.67ms, 50.6MB)
//		테스트 4 〉	통과 (0.83ms, 52.6MB)
//		테스트 5 〉	실패 (1.96ms, 50.3MB)
//		테스트 6 〉	통과 (0.87ms, 54.1MB)
//		테스트 7 〉	통과 (0.88ms, 52.2MB)
//		테스트 8 〉	실패 (1.66ms, 52.8MB)
//		테스트 9 〉	통과 (0.87ms, 52.4MB)
//		테스트 10 〉	통과 (0.92ms, 52.3MB)
//		테스트 11 〉	통과 (0.90ms, 52.2MB)
//		테스트 12 〉	통과 (0.88ms, 52MB)
//		테스트 13 〉	통과 (0.90ms, 52.6MB)
//		테스트 14 〉	통과 (0.92ms, 52.5MB)
//		테스트 15 〉	통과 (0.91ms, 50.5MB)
//		테스트 16 〉	통과 (0.93ms, 50.4MB)
//		테스트 17 〉	통과 (0.82ms, 52.5MB)
//		테스트 18 〉	실패 (1.70ms, 54.1MB)
//		테스트 19 〉	통과 (0.90ms, 50.5MB)
//		테스트 20 〉	실패 (1.77ms, 50.5MB)
//		테스트 21 〉	통과 (0.90ms, 50.5MB)
//		테스트 22 〉	실패 (1.74ms, 52.6MB)
//		테스트 23 〉	통과 (0.89ms, 52.4MB)
//		테스트 24 〉	통과 (1.81ms, 52.3MB)
//		테스트 25 〉	실패 (2.03ms, 52.9MB)
//		테스트 26 〉	통과 (0.83ms, 50.5MB)
//		테스트 27 〉	통과 (0.90ms, 50.3MB)
//		테스트 28 〉	통과 (0.87ms, 49.8MB)
//		테스트 29 〉	통과 (0.96ms, 50.5MB)
//		테스트 30 〉	통과 (0.87ms, 51.2MB)
//		테스트 31 〉	통과 (0.89ms, 53.1MB)
//		테스트 32 〉	통과 (0.91ms, 54MB)
		String dartResult="1D2S3T*";
		double []score = new double[4];
		char []bonus = new char[4];
		char []option = {'!','!','!'};

		int score_index=0, bonus_index=0;
		int []sum = new int[3];//점수1, 점수2, 점수3
		
		char[] str=dartResult.toCharArray();
		//System.out.println(str[6]);
		for(int i=0;i<str.length;i++) {//각 기회에 맞게 score[], bonus[], option[]
			if(str[i]== 48 && ((str[i-1] > 48) && (str[i-1] < 57))){//0이 존재할 경우 처리
				score[score_index-1] = 10;
			}
			else if(str[i] > 47 && str[i] < 57) {
				score[score_index] = (int)str[i]-48;
				score_index++;
			}
			else if(str[i] == 'S') {//'S'
				bonus[bonus_index] = 'S';
				bonus_index++;
			}
			else if(str[i] == 'D') {//'D'
				bonus[bonus_index]='D';
				bonus_index++;
			}
			else if(str[i]=='T') {//'T'
				bonus[bonus_index]='T';
				bonus_index++;
			}
			
			else if(str[i]=='*') {
				option[bonus_index-1]='*';
			}
			else if(str[i]=='#') {
				option[bonus_index-1]='#';
			}

		}
		
		for(int i=0;i<3;i++) {//각 score, bonus만 계산
			if(bonus[i]=='S'){
				sum[i]=(int) Math.pow(score[i], 1);
			}
			else if(bonus[i]=='D'){
				sum[i]=(int) Math.pow(score[i], 2);
			}
			if(bonus[i]=='T'){
				sum[i]=(int) Math.pow(score[i], 3);
			}
			
			if(option[i]=='#') {//아차상일 경우 마이너스 처리
				sum[i]=-sum[i];
			}
		}
		if(option[0]=='*' ) {//첫번째가 스타상일경우 점수 2배
			sum[0] *= 2;
		}
		if(option[1]=='*' && option[0] !='*' && option[2] !='*') {//두번째가 스타상일 경우 바로전 점수와 해당 점수 2배,스타상과 아차상 중첩될 경우 아차상 -2배
			sum[0] *= 2;
			sum[1] *= 2;
		}
		if(option[2]=='*' && option[0] !='*' && option[1] !='*') {//세번째가 스타상일 경우 바로전 점수와 해당 점수 2배
			sum[1] *= 2;
			sum[2] *=2;
		}
//		if(option[0]=='#' && (option[1]=='*' || option[2]=='*')) {//스타상과 아차상 중첩될 경우 아차상 -2배
//			sum[0] *= 2;//이미 위에서 마이너스처리해서 2배만 해줌
//		}
//		if(option[1]=='#' && (option[0]=='*' || option[2]=='*')) {//스타상과 아차상 중첩될 경우 아차상 -2배
//			sum[1] *= 2;//이미 위에서 마이너스처리해서 2배만 해줌
//		}
//		if(option[2]=='#' && (option[0]=='*' || option[1]=='*')) {//스타상과 아차상 중첩될 경우 아차상 -2배
//			sum[2] *= 2;//이미 위에서 마이너스처리해서 2배만 해줌
//		}
		if(option[0]=='*' && option[1]=='*') {//스타상 중첩시
			sum[0] *= 2;
			sum[1] *= 2;
		}
		if(option[1]=='*' && option[2]=='*') {//스타상 중첩시
			sum[1] *= 2;
			sum[2] *= 2;
		}
		if(option[0]=='*' && option[2]=='*') {//스타상 중첩시
			sum[0] *= 2;
			sum[2] *= 2;
		}
	
		int answer=sum[0]+sum[1]+sum[2];
		System.out.println(answer);

	}

}
