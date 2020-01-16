package safeboat;

import java.util.*;

public class Solution {
	// 최소의 구명보트를 사용하기 위해서
	// 가장 무거운 사람과 가장 가벼운 사람이 함께 보트를 태워보낸다.
    public int solution(int[] people, int limit) {
        int boat = 0;
        
        // 오름차순 정렬
        Arrays.sort(people);
        
        int index = 0;
        int revIndex = people.length - 1;
        // 이제 양 끝에서부터 하나씩 선택할 건데
        // 반복 종료 조건
        // 1. 선택된 인덱스가 같을 때
        // 2. 선택된 인덱스가 역전됐을 때
        while(true) {
        	// 1번 종료 조건
        	if (index == revIndex) {
        		boat++;
        		break;
        	}
        	
        	// 한 보트에 두 명을 태우지 못해
        	if (people[index] + people[revIndex] > limit) {
        		revIndex--;		// 무거운 놈 태워
        		boat++;
        	} 
        	// 한 보트에 두 명 태워
        	else {
        		revIndex--;		// 무거운 놈 태워
        		index++;		// 가벼운 놈 태워
        		boat++;
        		// 2번 종료 조건
        		if (index > revIndex)
        			break;
        	}
        	
        }
        
        return boat;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		// TEST case1 : return 3
//		int[] people = {70, 50, 80, 50};
//		int limit = 100;
		
		// TEST case2 : return 3
		int[] people = {70, 80, 50};
		int limit = 100;
		
		System.out.println(s.solution(people, limit));
		
	}
}
