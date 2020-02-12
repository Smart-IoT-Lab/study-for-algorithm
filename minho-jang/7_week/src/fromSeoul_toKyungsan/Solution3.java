package fromSeoul_toKyungsan;

public class Solution3 {
	final static int WALK = 0;
	final static int BIKE = 2;
	
	static boolean end = false;
	
    int count = 0;
    int[][] travel;
    int money;
    
	public int solution(int K, int[][] travel) {
        int answer = 0;
        
        this.travel = travel;
        
        doTravel(K, 0, WALK);
        doTravel(K, 0, BIKE);
        
        return money;
    }
	
	/**
	 * 
	 * @param time section에서 이용가능한 시간 (움직임 전)
	 * @param section 섹션 번호
	 * @param move 어떤 움직임을 선택. 0=walk, 2=bike
	 */
	void doTravel(int time, int section, int move) {
		System.out.println("section: " + section);
		if (end)
			return;
		
		// 끝까지 도달했다면 최적의 경로를 찾은 것.
		if (section == travel.length) {
			end = true;
			return;
		}
		
		// 이동한 후 이용가능한 시간
		int afterMove = time - travel[section][move];
		
		if (afterMove < 0)	// 아마 있을 수 없는 경우. 전에 다 처리를 하고 오므로.
			return;
		
		money += travel[section][move+1];
		
		// 다음 섹션에서 선택 가능한 경로 찾기
		// 둘다 불가능
		if (afterMove < travel[section+1][WALK] || afterMove < travel[section+1][BIKE]) {
			// 가능한 길이 없으니 돌아가
			return;
		}
		// 다음 섹션에서 도보 이용 불가능
		else if (afterMove < travel[section+1][WALK]) {
			doTravel(afterMove, section+1, BIKE);
		}
		// 다음 섹션에서 자전거 이용 불가능
		else if (afterMove < travel[section+1][BIKE]) {
	        doTravel(afterMove, section+1, WALK);
		}
		// 다음 섹션에서 둘다 이용 가능
		else {
			// 모금액 최대값 되도록
			int moneyWalk = travel[section+1][WALK+1];
			int moneyBike = travel[section+1][BIKE+1];
			if (moneyWalk > moneyBike)
				doTravel(afterMove, section+1, WALK);
			else
				doTravel(afterMove, section+1, BIKE);
		}
	}
}
