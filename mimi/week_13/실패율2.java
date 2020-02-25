import java.util.*;
public class kakakakakao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=5;
		int [] stages= {2,1,2,6,2,4,3,3};
		float numerator[] = new float[N];//����
		float denominator[] = new float[N];//�и�
		float failure[] = new float[N];
		int []answer=new int[N];
		int num=0, denom=0;

		
		for(int i=0;i<N;i++) {//�и�, ���������� ������ ��� ��
			denom=0;//�и�
			num=0;
			for(int j=0;j<stages.length;j++) {
				if(stages[j]>=i+1) {//���������� ������ �����(�и�)
					denom++;
				}
				if(stages[j]==i+1) {//���������� Ŭ���� ���� ��� ��(����)
					num++;
				}
			}
			denominator[i]=denom;//�и�
			numerator[i]=num;//����
			
		}

		float max=0;
		int index=0;
		
		for(int i=0;i<N;i++) {//������
			if(numerator[i]==0 ||denominator[i]==0) {//0�� ��� ó�� ���ϸ� ����
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
