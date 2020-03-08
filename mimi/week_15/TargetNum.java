import java.util.*;

public class TargetNum {
	
	static int answer=0;
	static int []numbers= {1,1,1,1,1};

	static public void Calculator(int arr[], int tar, int index, int sum){//Àç±ÍÇÔ¼ö
		int len= arr.length;
		if(index==len) {
			if(sum==tar) {
				answer++;
				return;
			}
			return;
		}
		else {
			Calculator(arr, tar, index+1, sum+arr[index]);//+
			Calculator(arr, tar, index+1, sum-arr[index]);//-
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int target=3;
		
		Calculator(numbers, target, 0, 0);
		System.out.println(answer);
		
	}

}
