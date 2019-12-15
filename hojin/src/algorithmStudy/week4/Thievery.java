package algorithmStudy.week4;

import java.util.HashMap;
import java.util.Arrays;

public class Thievery {
	// 재귀 풀이
	static int totalMoney = 0;
	public int solution0(int[] money) {
		int answer = 0;
		answer = thievery(money, totalMoney);
		return answer;	
	}
	public int thievery(int[] remainHouse, int totalMoney) {
		if(remainHouse.length == 0) { 
			return 0;
		} else if(remainHouse.length == 1) {
			return remainHouse[0];
		} else if(remainHouse.length == 2) {
			return Math.max(remainHouse[0], remainHouse[1]);
		} 
		
		int[] temp = Arrays.copyOf(remainHouse, remainHouse.length);
		int sum1, sum2;

		remainHouse = Arrays.copyOfRange(temp, 2, (temp.length - 1));
		sum1 = totalMoney + temp[0] + thievery(remainHouse, totalMoney);

		remainHouse = Arrays.copyOfRange(temp, 3, (temp.length));
		sum2 = totalMoney + temp[1] + thievery(remainHouse, totalMoney);
		return Math.max(sum1, sum2);	
	}
	
	//인터넷 풀이
	public int solution1(int[] money) {
        int answer = 0;
        int length = money.length;
        int[] dp =new int[length-1];
        int[] dp2= new int[length];
        
        dp[0]=money[0];
        dp[1]=money[0];
        
        dp2[0]=0;
        dp2[1]=money[1];
        for(int i=2;i<length-1;i++){
            dp[i]=Math.max(dp[i-2]+money[i],dp[i-1]);
        }
        for(int i=2;i<length;i++){
            dp2[i]=Math.max(dp2[i-2]+money[i],dp2[i-1]);
        }
        answer = Math.max(dp[length-2],dp2[length-1]);
        System.out.println(answer);
        return answer;
    }
	public int solution(int[] money) {
		int answer = 1;
		int length = money.length;
		HashMap<Integer, Integer> mem1 = new HashMap<>();
		HashMap<Integer, Integer> mem2 = new HashMap<>();
		
		mem1.put(0, money[0]);
		mem1.put(1, money[0]);
		mem2.put(0, 0);
		mem2.put(1, money[1]);
		
		for(int i=2;i<length-1;i++){
			int temp1 = mem1.get(i-2);
			System.out.println(temp1);
			int temp2 = mem1.get(i-1);
            int value = Math.max(temp1+money[i],);
			mem1.put(i, value);
        }
		for(int i=2;i<length;i++){
            int value = Math.max(mem2.get(i-2)+money[i],mem2.get(i-1));
			mem2.put(i, value);
        }
		answer = Math.max(mem1.get(length-2),mem2.get(length-1));
        System.out.println(answer);
		return answer;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thievery thieveryAgent = new Thievery();
		int [] money = {1, 2, 3, 1};
		thieveryAgent.solution(money);
	}

}
