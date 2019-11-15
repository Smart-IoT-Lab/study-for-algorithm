package hash;

import java.util.*;

public class Solution {
	
	/**
	 * 정확성  테스트
	 * 테스트 1 〉	통과 (0.93ms, 43.1MB)
	 * 테스트 2 〉	통과 (0.94ms, 42.5MB)
	 * 테스트 3 〉	통과 (4.05ms, 43.5MB)
	 * 테스트 4 〉	통과 (6.99ms, 44.5MB)
	 * 테스트 5 〉	통과 (5.63ms, 44.1MB)
	 * 효율성  테스트
	 * 테스트 1 〉	통과 (118.96ms, 81.7MB)
	 * 테스트 2 〉	통과 (205.06ms, 87.1MB)
	 * 테스트 3 〉	통과 (238.81ms, 94.1MB)
	 * 테스트 4 〉	통과 (328.78ms, 93.2MB)
	 * 테스트 5 〉	통과 (334.15ms, 93.3MB)
	 * 
	 * @param participant
	 * @param completion
	 * @return
	 */
	public String solution(String[] participant, String[] completion) {
        String answer = "NaN";
        
        // 참가자가 1명
        if (completion.length < 1)
        	return participant[0];
       
        // String 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 문자열 비교
        for (int i = 0; i < participant.length; i++) {
        	
        	if (i == participant.length - 1)
        		return participant[participant.length - 1];
        	
        	if (!participant[i].equals(completion[i]))
        		return participant[i];
        }
        
        return answer;
    }
	
	/**
	 * 정확성 테스트
	 * 테스트 1 〉	통과 (0.99ms, 42.6MB)
	 * 테스트 2 〉	통과 (0.97ms, 43.1MB)
	 * 테스트 3 〉	통과 (1.20ms, 43.7MB)
	 * 테스트 4 〉	통과 (1.85ms, 44.1MB)
	 * 테스트 5 〉	통과 (1.64ms, 44MB)
	 * 효율성  테스트
	 * 테스트 1 〉	통과 (32.34ms, 81.6MB)
	 * 테스트 2 〉	통과 (61.55ms, 87MB)
	 * 테스트 3 〉	통과 (57.29ms, 91.7MB)
	 * 테스트 4 〉	통과 (46.39ms, 104MB)
	 * 테스트 5 〉	통과 (113.36ms, 102MB)
	 * 
	 * @param participant
	 * @param completion
	 * @return
	 */
	public String solution2(String[] participant, String[] completion) {
		String answer = "NaN";
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		// 완주한 사람에 대한 HashMap. 등장횟수만큼 value 증가.
		for (String s : completion) {
			if (hm.containsKey(s))	 {
				int i = hm.get(s);
				hm.replace(s, i, ++i);
			} else {
				hm.put(s, 1);
			}
		}
		
		// 완주한 사람의 HashMap에서 없는 참여자 이름이 있는지 확인. 등장횟수만큼 value 감소.
		for (String s : participant) {
			if (hm.containsKey(s))	 {
				int i = hm.get(s);
				// 동명이인인데 그만큼 value가 없으므로 그 사람이 범인이다.
				if (i == 0) 
					return s;
				
				hm.replace(s, i, --i);
			} else {
				// 이름이 존재하지 않은 경우
				return s;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		String[] participant = {"m", "s", "m", "a"};
		String[] completion = {"s", "a", "m"};

		System.out.println(solution.solution2(participant, completion));
	}
}
