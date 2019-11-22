package algorithmStudy.week3;

import java.util.Collections;
import java.util.PriorityQueue;


class SupplyInfo implements Comparable<SupplyInfo>
{
	int date;
	int supply;
	
	public SupplyInfo(int date, int supply)
	{
		super();
		this.date = date;
		this.supply = supply; 
	}
	
	@Override
	public int compareTo(SupplyInfo target)
	{
		// 보급량에 따라 오름차순 정렬
		if (this.supply > target.supply) {
			return 1;
		} else if (this.supply < target.supply) {
			return -1;
		}
		return 0;
	}
}

public class NoodleFactory {

	public int solution(int stock, int[] dates, int[] supplies, int k){
		int answer = 0;
		
//		PriorityQueue<SupplyInfo> priorityQueue = new PriorityQueue<SupplyInfo>();
//		
//		for (int idx = 0; idx < dates.length; idx++){
//        	// 중복 보급일 없다고 가정
//        	priorityQueue.add(new SupplyInfo(dates[idx], supplies[idx]));
//		}
		
		// SupplyInfo 클래스의 compareTo를 내림차순으로 구현하면 순서를 뒤집는 과정 필요없음
		// 이해를 위해 아래 처럼 진행
		PriorityQueue<SupplyInfo> reversedPriorityQueue = 
				new PriorityQueue<SupplyInfo>(dates.length, Collections.reverseOrder());
		
		int cnt = 0;
				
		while(stock < k){
			
			for(int idx = cnt; idx < dates.length; idx++){
				// 현재 재고 보다 보급일이 작으면 큐에 넣음
				if(stock >= dates[idx])
				{
					reversedPriorityQueue.add(new SupplyInfo(dates[idx], supplies[idx]));
				}else {
					cnt = idx;
					break;
				}
			}
			
			// 큐가 비었거나 모든 재고 소진한 경우 처리 필요 ->
			// 밀가루가 바닥나는 경우는 없으므로 처리 안함
			
			SupplyInfo supplyInfo = reversedPriorityQueue.poll();
			
			int supply = supplyInfo.supply;
			System.out.println("supply : " + supply);
			
			stock += supply;
			System.out.println("stock : " + stock);

			answer++;	
		}
		System.out.println(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoodleFactory noodleFactoryAgent = new NoodleFactory();
		int stock = 4; 
		int[] dates = {4, 10, 15};
		int[] supplies = {20, 5, 10}; 
		int k = 30;
		System.out.println("expected answer 2");
		noodleFactoryAgent.solution(stock, dates, supplies, k);
	}
}
