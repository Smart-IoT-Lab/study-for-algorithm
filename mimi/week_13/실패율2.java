import java.util.*;
public class kakakakakao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=5;
		int [] stages= {2,1,2,6,2,4,3,3};
		float numerator[] = new float[N];//분자
		float denominator[] = new float[N];//분모
		float failure[] = new float[N];
		int []answer=new int[N];
		int num=0, denom=0;

		
		for(int i=0;i<N;i++) {//분모, 스테이지에 도달한 사람 수
			denom=0;//분모
			num=0;
			for(int j=0;j<stages.length;j++) {
				if(stages[j]>=i+1) {//스테이지에 도달한 사람수(분모)
					denom++;
				}
				if(stages[j]==i+1) {//도달했지만 클리어 못한 사람 수(분자)
					num++;
				}
			}
			denominator[i]=denom;//분모
			numerator[i]=num;//분자
			
		}

		float max=0;
		int index=0;
		
		for(int i=0;i<N;i++) {//실패율
			if(numerator[i]==0 ||denominator[i]==0) {//0일 경우 처리 안하면 에러
				failure[i]=0;
			}
			else {
				failure[i]=numerator[i]/denominator[i];
			}

		}
		
		for(int i=0;i<N;i++) {
			System.out.println(failure[i]);
		}
		
		for(int i=0;i<N;i++) {
			max=-1;	
			for(int j=0;j<N;j++) {
				if(max<failure[j]) {
					max=failure[j];
					index=j;
				}
			}
			answer[i]=index+1;
			failure[index]=-2;
			
		}
		for(int i=0;i<N;i++) {
			System.out.print(answer[i]);
		}
		
	}

}
