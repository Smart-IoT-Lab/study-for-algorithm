package integer_triangle;

public class Solution {
	/**
	 * �Ʒ��� ���� �ִ밪�� ã���鼭 �ﰢ���� �����.
	 * �ﰢ�� ��ü�� ����� ���� �ƴ϶�
	 * �ﰢ���� ����鼭 �ʿ��� ���鸸 �迭�� �����ϸ鼭 for������ �ݺ��Ѵ�.
	 * 
	 * @param triangle �����ﰢ��
	 * @return ��ΰ� ������ �ִ밪
	 */
	public int solution(int[][] triangle) {
        int bottomIndex = triangle.length-1;
        
        int maxLength = triangle[bottomIndex].length;
        int[] parentsInteger = new int[maxLength];	// ���� ����ϰ� �ִ� ��
        int[] childsInteger = new int[maxLength];	// ���� �� ��꿡�� �̿�� ���� ��
        
        for (int floor = bottomIndex; floor >= 0; floor--) {
        	// �� �����̸�
        	if (floor == bottomIndex)
        		parentsInteger = triangle[bottomIndex];
        	// �� �عٴ��� �ƴϸ�
        	else {
        		// ���� parents�� �ڽ����� ��������
        		childsInteger = parentsInteger;
        		//			�� ���� �ش� ���� ���� ����	
        		for (int i=0; i <= floor; i++) {
        			// ���� �������ִ� �ִ밪			����			+		�Ʒ� �ڽ� �� �ִ밪
            		parentsInteger[i] = triangle[floor][i] + Math.max(childsInteger[i], childsInteger[i+1]);
        		}
        	}
        }
        
        return parentsInteger[0];
    }
	
	public static void main(String args[]) {
		Solution s = new Solution();
		
		int[][] triangle = {
				{7},
				{3,8},
				{8,1,0},
				{2,7,4,4},
				{4,5,2,6,5}
		};
		
		System.out.println(s.solution(triangle));
	}
}