import java.util.*;

public class DartGame {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		�׽�Ʈ 1 ��	��� (0.92ms, 52.4MB)
//		�׽�Ʈ 2 ��	��� (0.77ms, 52MB)
//		�׽�Ʈ 3 ��	���� (1.67ms, 50.6MB)
//		�׽�Ʈ 4 ��	��� (0.83ms, 52.6MB)
//		�׽�Ʈ 5 ��	���� (1.96ms, 50.3MB)
//		�׽�Ʈ 6 ��	��� (0.87ms, 54.1MB)
//		�׽�Ʈ 7 ��	��� (0.88ms, 52.2MB)
//		�׽�Ʈ 8 ��	���� (1.66ms, 52.8MB)
//		�׽�Ʈ 9 ��	��� (0.87ms, 52.4MB)
//		�׽�Ʈ 10 ��	��� (0.92ms, 52.3MB)
//		�׽�Ʈ 11 ��	��� (0.90ms, 52.2MB)
//		�׽�Ʈ 12 ��	��� (0.88ms, 52MB)
//		�׽�Ʈ 13 ��	��� (0.90ms, 52.6MB)
//		�׽�Ʈ 14 ��	��� (0.92ms, 52.5MB)
//		�׽�Ʈ 15 ��	��� (0.91ms, 50.5MB)
//		�׽�Ʈ 16 ��	��� (0.93ms, 50.4MB)
//		�׽�Ʈ 17 ��	��� (0.82ms, 52.5MB)
//		�׽�Ʈ 18 ��	���� (1.70ms, 54.1MB)
//		�׽�Ʈ 19 ��	��� (0.90ms, 50.5MB)
//		�׽�Ʈ 20 ��	���� (1.77ms, 50.5MB)
//		�׽�Ʈ 21 ��	��� (0.90ms, 50.5MB)
//		�׽�Ʈ 22 ��	���� (1.74ms, 52.6MB)
//		�׽�Ʈ 23 ��	��� (0.89ms, 52.4MB)
//		�׽�Ʈ 24 ��	��� (1.81ms, 52.3MB)
//		�׽�Ʈ 25 ��	���� (2.03ms, 52.9MB)
//		�׽�Ʈ 26 ��	��� (0.83ms, 50.5MB)
//		�׽�Ʈ 27 ��	��� (0.90ms, 50.3MB)
//		�׽�Ʈ 28 ��	��� (0.87ms, 49.8MB)
//		�׽�Ʈ 29 ��	��� (0.96ms, 50.5MB)
//		�׽�Ʈ 30 ��	��� (0.87ms, 51.2MB)
//		�׽�Ʈ 31 ��	��� (0.89ms, 53.1MB)
//		�׽�Ʈ 32 ��	��� (0.91ms, 54MB)
		String dartResult="1D2S3T*";
		double []score = new double[4];
		char []bonus = new char[4];
		char []option = {'!','!','!'};

		int score_index=0, bonus_index=0;
		int []sum = new int[3];//����1, ����2, ����3
		
		char[] str=dartResult.toCharArray();
		//System.out.println(str[6]);
		for(int i=0;i<str.length;i++) {//�� ��ȸ�� �°� score[], bonus[], option[]
			if(str[i]== 48 && ((str[i-1] > 48) && (str[i-1] < 57))){//0�� ������ ��� ó��
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
		
		for(int i=0;i<3;i++) {//�� score, bonus�� ���
			if(bonus[i]=='S'){
				sum[i]=(int) Math.pow(score[i], 1);
			}
			else if(bonus[i]=='D'){
				sum[i]=(int) Math.pow(score[i], 2);
			}
			if(bonus[i]=='T'){
				sum[i]=(int) Math.pow(score[i], 3);
			}
			
			if(option[i]=='#') {//�������� ��� ���̳ʽ� ó��
				sum[i]=-sum[i];
			}
		}
		if(option[0]=='*' ) {//ù��°�� ��Ÿ���ϰ�� ���� 2��
			sum[0] *= 2;
		}
		if(option[1]=='*' && option[0] !='*' && option[2] !='*') {//�ι�°�� ��Ÿ���� ��� �ٷ��� ������ �ش� ���� 2��,��Ÿ��� ������ ��ø�� ��� ������ -2��
			sum[0] *= 2;
			sum[1] *= 2;
		}
		if(option[2]=='*' && option[0] !='*' && option[1] !='*') {//����°�� ��Ÿ���� ��� �ٷ��� ������ �ش� ���� 2��
			sum[1] *= 2;
			sum[2] *=2;
		}
//		if(option[0]=='#' && (option[1]=='*' || option[2]=='*')) {//��Ÿ��� ������ ��ø�� ��� ������ -2��
//			sum[0] *= 2;//�̹� ������ ���̳ʽ�ó���ؼ� 2�踸 ����
//		}
//		if(option[1]=='#' && (option[0]=='*' || option[2]=='*')) {//��Ÿ��� ������ ��ø�� ��� ������ -2��
//			sum[1] *= 2;//�̹� ������ ���̳ʽ�ó���ؼ� 2�踸 ����
//		}
//		if(option[2]=='#' && (option[0]=='*' || option[1]=='*')) {//��Ÿ��� ������ ��ø�� ��� ������ -2��
//			sum[2] *= 2;//�̹� ������ ���̳ʽ�ó���ؼ� 2�踸 ����
//		}
		if(option[0]=='*' && option[1]=='*') {//��Ÿ�� ��ø��
			sum[0] *= 2;
			sum[1] *= 2;
		}
		if(option[1]=='*' && option[2]=='*') {//��Ÿ�� ��ø��
			sum[1] *= 2;
			sum[2] *= 2;
		}
		if(option[0]=='*' && option[2]=='*') {//��Ÿ�� ��ø��
			sum[0] *= 2;
			sum[2] *= 2;
		}
	
		int answer=sum[0]+sum[1]+sum[2];
		System.out.println(answer);

	}

}
