import java.util.*;
import java.util.Arrays;
public class Greedy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;//정점 수, 섬 개수
	
		int answer=0;//최소 비용
		int [][]costs= {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}};
		
		
		int [][]costs2=new int[4][3];//선택된 간선 기억
		int edgCnt=0;//현재 추가된 간선 수
		int i=0, v1, v2, s1, s2;//v1,v2느 선택된 정점의 임시 저장 변수, s1,s2는 같은 서브 트리인지 확인하기 위한 변수
		int []s=new int[n+1];//서브트리
		
		for(int j=0;j<n+1;j++) {
			s[j]=j;
			}

		//1.오름차순 정렬 
		Arrays.parallelSort(costs,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});		

		//2. 낮은 거 부터 추가
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
