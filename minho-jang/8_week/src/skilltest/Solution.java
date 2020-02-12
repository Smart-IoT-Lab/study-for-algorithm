package skilltest;

/**
 * ���ڿ� s���� �������� ���е� ���ڵ��� ����Ǿ� �ֽ��ϴ�. str�� ��Ÿ���� ���� �� �ּҰ��� �ִ밪�� ã�� �̸� (�ּҰ�)
 * (�ִ밪)������ ���ڿ��� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���. ������� s�� 1 2 3 4��� 1 4�� �����ϰ�, -1 -2 -3
 * -4��� -4 -1�� �����ϸ� �˴ϴ�.
 * 
 * ���� ���� s���� �� �̻��� ������ �������� ���еǾ� �ֽ��ϴ�.
 * 
 * ***************************************************************************************
 * 
 * ���ε��� ���� ������� ����Ʈ�� �̿��Ͽ� �����Ϸ��� �մϴ�. ����Ʈ�� �۾Ƽ� �� ���� �ִ� 2�� �ۿ� Ż �� ����, ���� ���ѵ�
 * �ֽ��ϴ�.
 * 
 * ���� ���, ������� �����԰� [70kg, 50kg, 80kg, 50kg]�̰� ����Ʈ�� ���� ������ 100kg�̶�� 2��° ����� 4��°
 * ����� ���� Ż �� ������ 1��° ����� 3��° ����� ������ ���� 150kg�̹Ƿ� ����Ʈ�� ���� ������ �ʰ��Ͽ� ���� Ż �� �����ϴ�.
 * 
 * ����Ʈ�� �ִ��� ���� ����Ͽ� ��� ����� �����Ϸ��� �մϴ�.
 * 
 * ������� �����Ը� ���� �迭 people�� ����Ʈ�� ���� ���� limit�� �Ű������� �־��� ��, ��� ����� �����ϱ� ���� �ʿ���
 * ����Ʈ ������ �ּڰ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * ���ѻ��� ���ε��� ���� ����� 1�� �̻� 50,000�� �����Դϴ�. �� ����� �����Դ� 40kg �̻� 240kg �����Դϴ�. ����Ʈ��
 * ���� ������ 40kg �̻� 240kg �����Դϴ�. ����Ʈ�� ���� ������ �׻� ������� ������ �� �ִ񰪺��� ũ�� �־����Ƿ� �������
 * ������ �� ���� ���� �����ϴ�.
 * 
 * @author YR
 *
 */
import java.util.*;

public class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;
		
		Integer[] reverse = Arrays.stream(people).boxed().toArray( Integer[] ::new);
		Arrays.sort(reverse, Comparator.reverseOrder());

		int[] boat = new int[people.length];
		ArrayList<Integer> leavedWeight = new ArrayList<Integer>();

		boat[0] = 1;
		leavedWeight.add(limit - reverse[0]);

		for (int i = 1; i < people.length; i++) {
			boolean updated = false;
			for (int j=0; j<leavedWeight.size(); j++) {
				if (leavedWeight.get(j) >= reverse[i]) {
					leavedWeight.remove(j);
					boat[i] = boat[i - 1];
					updated = true;
					break;
				}
			}

			if (!updated) {
				boat[i] = boat[i - 1] + 1;
				leavedWeight.add(limit - reverse[i]);
			}
		}

		for (int i : boat)
			System.out.print(i + " ");
		System.out.println();

		for (int i : leavedWeight)
			System.out.print(i + " ");
		System.out.println();

		answer = boat[boat.length - 1];
		return answer;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		int[] people = { 70, 50, 80, 50, 100, 120, 120 };
		int limit = 200;

		System.out.println(s.solution(people, limit));
	}
}
