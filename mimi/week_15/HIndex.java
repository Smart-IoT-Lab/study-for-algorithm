import java.util.*;

public class HIndex {
	
	static public int Max(int array[], int len) {//�ִ밪
		int max=0;
		for(int i=0;i<len;i++) {
			if(max<array[i]) {
				max=array[i];
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []citations = {20,19,18,1};
		int n = citations.length;
		int answer = 0, num=0,m=0;
		
		m=Max(citations, n);
		
		for(int i=0;i<m;i++) {
			num=0;
			for(int j=0;j<n;j++) {
				if(i <= citations[j]) {
					num++;
				}
			}
			if(num >= i) {
				answer=i;
			}
		}
		
		System.out.println(answer);
	}

}
