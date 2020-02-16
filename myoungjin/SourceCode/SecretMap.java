import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		int n = 5;
		int arr1[] = {9, 20, 28, 18, 11};
		int arr2[] = {30, 1, 21, 17, 28};
		System.out.println(Arrays.toString(solution(n,arr1,arr2)));
	}
	 public static String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];
	      for (int i=0;i<n;i++) {
	    	  answer[i] = duo(n,makeBin(n,arr1[i]),makeBin(n,arr2[i]));
	      }
	      return answer;
	 }
	 
	 public static String makeBin (int n,int ten) {
		 String bin1 = "";
		 String  temp = "";
		 while (true) {
			 if (ten == 1) {
				 bin1 += "1";
				 break;
			 }
			 else if (ten == 0) {
				 break;
			 }
			 bin1 += Integer.toString(ten%2);
			 ten /=2;
			 if (ten/2 == 1) {
				 bin1 += Integer.toString(ten%2);
				 bin1 += "1";
				 break;
			 }
		 }
	
		 while (temp.length() < n - bin1.length()) {
			 temp += "0";
		 }
		 bin1 += temp;
		 
		 return reverseString(bin1);
	 }
	 
	 public static String duo (int n,String one,String two) {
		 String answer ="";
		 for (int i=0;i<n;i++) {
			 if (one.substring(i, i+1).equals("1") || two.substring(i,i+1).equals("1"))
				 answer += "#";
			 else
				 answer += " ";
		 }
		 return answer;
	 }
	 
	  public static String reverseString(String s) {
		    return ( new StringBuffer(s) ).reverse().toString();
		    }
}