import java.util.*;
//비밀지도
public class kakaotest {
	
	static public int[][] toBinary(int map[],int n) {//이진수값으로 바꾸기
		int []save= {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536};
		int index=0;
		int [][]array= new int [n][n];
		
		for(int i=0; i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[index]-save[n-j-1]>=0) {
					map[index]=map[index]-save[n-j-1];
					array[index][j]=1;//#대신 1로
				}
				else {
					array[index][j]=0;
				}
			}
			index++;
		}
		
		return array;
	}
	
	static public int[][] plusMap(int a[][],int b[][], int n){//지도 합치기
		int plus[][]=new int [n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j]==0 && b[i][j]==0) {//지도 1,2가 둘다 공백이면 공백
					plus[i][j]=0;
				}
				else {//하나라도 벽이면 벽
					plus[i][j]=1;
				}
			}	
		}
		
		return plus;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int []arr1 = {9,20,28,18,11};
		int []arr2 = {30,1,21,17,28};
		int [][]array1;
		int [][]array2;
		int map[][];
		String answer[]=new String [n];
		
		array1=toBinary(arr1,n);
		array2=toBinary(arr2,n);
		map=plusMap(array1,array2,n);//지도 합치기
	
		for(int i=0;i<n;i++) {
			answer[i]="9";//처음 초기화시켜놔야해서 함
			for(int j=0;j<n;j++) {
				String num=String.valueOf(map[i][j]);//한줄씩 string으로
				answer[i]=answer[i]+num;//
			}
		}
		
		for(int i=0;i<n;i++) {
			answer[i]=answer[i].substring(1);
			if(answer[i].contains("1")) {
				answer[i]=answer[i].replace("1", "#");//1은 벽으로
			}
		}
		
		for(int i=0;i<n;i++) {
			if(answer[i].contains("0")) {
				answer[i]=answer[i].replace("0", " ");//0은 공백으로
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(answer[i]);
		}
	}

}
