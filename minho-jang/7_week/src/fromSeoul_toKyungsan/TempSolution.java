package fromSeoul_toKyungsan;

public class TempSolution {
	int[][] travel;	
	// int[][] visited;
	
	public int solution(int K, int[][] travel) {
        int answer = 0;
        
        this.travel = travel;
        
        // 각 구간별 자전거 또는 도보 선택시의 최대값 저장
        // visited = new int[travel.length][2];
        
        answer = doTravel(K, 0);
        
        // answer = Math.max(visited[0][0], visited[0][1]);
        
        return answer;
    }
	
	int doTravel(int time, int section) {
		
		if (time < 0)
			return -1;
		
		if (section >= travel.length)
			return 0;
		
		int walk = doTravel(time-travel[section][0], section+1);
		int bicycle = doTravel(time-travel[section][2], section+1);
		
		if (walk == -1)
			walk = 0;
		else 
			walk += travel[section][1];
		
		if (bicycle == -1)
			bicycle = 0;
		else 
			bicycle += travel[section][3];
		
		
		System.out.println("section: " + section + "\t K = " + time
				+ "\n  walk = " + (walk) + "\n  bicycle = " + (bicycle));
		
		if (walk > bicycle)
			return walk;
		else 
			return bicycle;
	}
}
