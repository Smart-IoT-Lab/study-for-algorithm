package tile_decoratation;

public class Solution {
	/**
	 * ���� Ÿ���� �����ϴ� ���簢�� �� ���� ���� = {1, 1, 2, 3, 5, 8 ... }
	 * >> An+1 = An + An-1
	 * 
	 * ���� ū ���簢�� �ѷ��� ���� ��Ģ�� ����
	 * >> Bn+1 = Bn + 2*An
	 * 
	 * ���� ��ȭ���� �̿��Ͽ� N�� �ݺ��ϸ� �ȴ�.
	 * 
	 * @param N Ÿ���� ����
	 * @return ���簢�� �ѷ��� ��
	 */
	public long solution(int N) {
		//		An				An+1 < ��� ���翡�� �ʿ������ ���� ���� ���� �� ���ϰž�
        long tempSide1 = 1, tempSide2 = 1;
        
        // ���簢�� �ѷ��� ��, �� answer.
        long sumSides = 4;
        
        // N=1�� ���� ��Ȳ���� �ʱ�ȭ �����Ƿ�
        // N-1�� �ݺ��Ѵ�.
        for (int countTile = 1; countTile < N; countTile++) {
        	long t = tempSide1;
        	tempSide1 = tempSide2;
        	tempSide2 = t + tempSide2;
        	
        	sumSides = sumSides + 2*tempSide1;
        }
        
        return sumSides;
    }
	
	public static void main(String args[]) {
		Solution s = new Solution();
		
		int N = 5;
		System.out.println(s.solution(N));
	}

}

