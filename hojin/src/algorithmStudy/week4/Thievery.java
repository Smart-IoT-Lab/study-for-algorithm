package algorithmStudy.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Thievery {
	static HashMap<Integer, Integer> cache = new HashMap<>();
	
	public int solution(int[] money) {
		int answer = 0;
		return answer;
	}
	public int thievery(int[] remainHouse) {
		if(remainHouse.length == 0) { 
			return 0;
		} else if(remainHouse.length == 1) {
			return Math.max(remainHouse[0], remainHouse[1]);
		} else {
			//TODO
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thievery thieveryAgent = new Thievery();
		int [] money = {1, 2, 3, 1};
		thieveryAgent.solution(money);
	}

}
