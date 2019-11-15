package algorithmStudy.week2;

import java.util.HashMap;

public class UnReachedPlayer {

	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> playerHashMap = new HashMap<>();
        for (String player : participant)
        	// getOrDefault는 key(arg[0]) 대응 값이 있으면 해당 값을 없으면 디폴트 값(arg[1])을 가져온다.
        	// 중복 플레이어 처리를 위해 getOrDefault 사용
        	playerHashMap.put(player, playerHashMap.getOrDefault(player, 0) + 1);
        for (String player : completion)
        	// 플레이어 일치 할때마다 value 1씩 줄임
        	playerHashMap.put(player, playerHashMap.get(player) - 1);
        System.out.println(playerHashMap.toString());
        
        for (String key : playerHashMap.keySet()) {
        	// key값이 0이 아니면 오나주 하지 못한 경우
            if (playerHashMap.get(key) != 0){
                answer = key;
                break;
            }
        }
        
        System.out.println(answer);
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnReachedPlayer UnReachedPlayerAgent = new UnReachedPlayer();
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"mislav", "stanko", "ana"};
		
		UnReachedPlayerAgent.solution(participant, completion);
	}

}
