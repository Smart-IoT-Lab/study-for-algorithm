package hash;

import java.util.*;

public class Solution {
	
	/**
	 * ��Ȯ��  �׽�Ʈ
	 * �׽�Ʈ 1 ��	��� (0.93ms, 43.1MB)
	 * �׽�Ʈ 2 ��	��� (0.94ms, 42.5MB)
	 * �׽�Ʈ 3 ��	��� (4.05ms, 43.5MB)
	 * �׽�Ʈ 4 ��	��� (6.99ms, 44.5MB)
	 * �׽�Ʈ 5 ��	��� (5.63ms, 44.1MB)
	 * ȿ����  �׽�Ʈ
	 * �׽�Ʈ 1 ��	��� (118.96ms, 81.7MB)
	 * �׽�Ʈ 2 ��	��� (205.06ms, 87.1MB)
	 * �׽�Ʈ 3 ��	��� (238.81ms, 94.1MB)
	 * �׽�Ʈ 4 ��	��� (328.78ms, 93.2MB)
	 * �׽�Ʈ 5 ��	��� (334.15ms, 93.3MB)
	 * 
	 * @param participant
	 * @param completion
	 * @return
	 */
	public String solution(String[] participant, String[] completion) {
        String answer = "NaN";
        
        // �����ڰ� 1��
        if (completion.length < 1)
        	return participant[0];
       
        // String ����
        Arrays.sort(participant);
        Arrays.sort(completion);

        // ���ڿ� ��
        for (int i = 0; i < participant.length; i++) {
        	
        	if (i == participant.length - 1)
        		return participant[participant.length - 1];
        	
        	if (!participant[i].equals(completion[i]))
        		return participant[i];
        }
        
        return answer;
    }
	
	/**
	 * ��Ȯ�� �׽�Ʈ
	 * �׽�Ʈ 1 ��	��� (0.99ms, 42.6MB)
	 * �׽�Ʈ 2 ��	��� (0.97ms, 43.1MB)
	 * �׽�Ʈ 3 ��	��� (1.20ms, 43.7MB)
	 * �׽�Ʈ 4 ��	��� (1.85ms, 44.1MB)
	 * �׽�Ʈ 5 ��	��� (1.64ms, 44MB)
	 * ȿ����  �׽�Ʈ
	 * �׽�Ʈ 1 ��	��� (32.34ms, 81.6MB)
	 * �׽�Ʈ 2 ��	��� (61.55ms, 87MB)
	 * �׽�Ʈ 3 ��	��� (57.29ms, 91.7MB)
	 * �׽�Ʈ 4 ��	��� (46.39ms, 104MB)
	 * �׽�Ʈ 5 ��	��� (113.36ms, 102MB)
	 * 
	 * @param participant
	 * @param completion
	 * @return
	 */
	public String solution2(String[] participant, String[] completion) {
		String answer = "NaN";
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		// ������ ����� ���� HashMap. ����Ƚ����ŭ value ����.
		for (String s : completion) {
			if (hm.containsKey(s))	 {
				int i = hm.get(s);
				hm.replace(s, i, ++i);
			} else {
				hm.put(s, 1);
			}
		}
		
		// ������ ����� HashMap���� ���� ������ �̸��� �ִ��� Ȯ��. ����Ƚ����ŭ value ����.
		for (String s : participant) {
			if (hm.containsKey(s))	 {
				int i = hm.get(s);
				// ���������ε� �׸�ŭ value�� �����Ƿ� �� ����� �����̴�.
				if (i == 0) 
					return s;
				
				hm.replace(s, i, --i);
			} else {
				// �̸��� �������� ���� ���
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
