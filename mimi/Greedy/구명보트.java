import java.util.*;

public class Greedy1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []people= {70,50,80,50,100};
		
		int limit=100;
		int answer=0;
		Arrays.sort(people);
		
		int high=people.length-1;
		int low=0;
				
		while(high>=low) {
		
			if(people[high]+people[low]<=100) {
				high--;
				low++;

			}
			else {
				high--;
				
			}
			answer++;
		}
		System.out.println(answer);
		
	}

}
