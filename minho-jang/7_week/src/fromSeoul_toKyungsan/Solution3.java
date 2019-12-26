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
	 * @param time section���� �̿밡���� �ð� (������ ��)
	 * @param section ���� ��ȣ
	 * @param move � �������� ����. 0=walk, 2=bike
	 */
	void doTravel(int time, int section, int move) {
		System.out.println("section: " + section);
		if (end)
			return;
		
		// ������ �����ߴٸ� ������ ��θ� ã�� ��.
		if (section == travel.length) {
			end = true;
			return;
		}
		
		// �̵��� �� �̿밡���� �ð�
		int afterMove = time - travel[section][move];
		
		if (afterMove < 0)	// �Ƹ� ���� �� ���� ���. ���� �� ó���� �ϰ� ���Ƿ�.
			return;
		
		money += travel[section][move+1];
		
		// ���� ���ǿ��� ���� ������ ��� ã��
		// �Ѵ� �Ұ���
		if (afterMove < travel[section+1][WALK] || afterMove < travel[section+1][BIKE]) {
			// ������ ���� ������ ���ư�
			return;
		}
		// ���� ���ǿ��� ���� �̿� �Ұ���
		else if (afterMove < travel[section+1][WALK]) {
			doTravel(afterMove, section+1, BIKE);
		}
		// ���� ���ǿ��� ������ �̿� �Ұ���
		else if (afterMove < travel[section+1][BIKE]) {
	        doTravel(afterMove, section+1, WALK);
		}
		// ���� ���ǿ��� �Ѵ� �̿� ����
		else {
			// ��ݾ� �ִ밪 �ǵ���
			int moneyWalk = travel[section+1][WALK+1];
			int moneyBike = travel[section+1][BIKE+1];
			if (moneyWalk > moneyBike)
				doTravel(afterMove, section+1, WALK);
			else
				doTravel(afterMove, section+1, BIKE);
		}
	}
}
