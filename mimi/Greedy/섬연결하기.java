import java.util.*;
import java.util.Arrays;
public class Greedy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;//���� ��, �� ����
	
		int answer=0;//�ּ� ���
		int [][]costs= {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}};
		
		int [][]costs2=new int[4][3];//���õ� ���� ���
		int edgCnt=0;//���� �߰��� ���� ��
		int i=0, v1, v2, s1, s2;//v1,v2�� ���õ� ������ �ӽ� ���� ����, s1,s2�� ���� ���� Ʈ������ Ȯ���ϱ� ���� ����
		int []s=new int[n+1];//����Ʈ��
		
		for(int j=0;j<n+1;j++) {
			s[j]=j;
			}

		//1.�������� ���� 
		Arrays.parallelSort(costs,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});		

		//2. ���� �� ���� �߰�
		while(edgCnt<n-1) {
			v1=costs[i][0];
			v2=costs[i][1];
			s1=s[v1];
			s2=s[v2];
			if(s1!=s2 ) {
				for(int j=0;j<s.length;j++) {
					if(s[j]==s2) {
						s[j]=s1;
					}
				}
				answer+=costs[i][2];
				edgCnt++;
			}
			i++;
		}
		System.out.println(answer);

	}

}
