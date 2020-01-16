package safeboat;

import java.util.*;

public class Solution {
	// �ּ��� ����Ʈ�� ����ϱ� ���ؼ�
	// ���� ���ſ� ����� ���� ������ ����� �Բ� ��Ʈ�� �¿�������.
    public int solution(int[] people, int limit) {
        int boat = 0;
        
        // �������� ����
        Arrays.sort(people);
        
        int index = 0;
        int revIndex = people.length - 1;
        // ���� �� ���������� �ϳ��� ������ �ǵ�
        // �ݺ� ���� ����
        // 1. ���õ� �ε����� ���� ��
        // 2. ���õ� �ε����� �������� ��
        while(true) {
        	// 1�� ���� ����
        	if (index == revIndex) {
        		boat++;
        		break;
        	}
        	
        	// �� ��Ʈ�� �� ���� �¿��� ����
        	if (people[index] + people[revIndex] > limit) {
        		revIndex--;		// ���ſ� �� �¿�
        		boat++;
        	} 
        	// �� ��Ʈ�� �� �� �¿�
        	else {
        		revIndex--;		// ���ſ� �� �¿�
        		index++;		// ������ �� �¿�
        		boat++;
        		// 2�� ���� ����
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
