package baekjoon_11729;
// �ϳ��� ž �̵� ����

import java.util.*;

public class Main {
	static int count = 0;
	// StringBuilder ��� �� ���� System.out.println()�� �����ϴ� �ð��ʰ��� ����.
	static StringBuilder sb;
	
	// A Ÿ���� � �عٴ� ���� bottom�� C Ÿ���� �Űܾ� �� ��,
	// A Ÿ���� ���� bottom ���� �ִ� ���ݵ��� �ٸ� B Ÿ���� ��� �Űܾ� �Ѵ�.
	public static void main(String[] args) {
		/////////// �Է� �� �ʱ�ȭ
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		sb = new StringBuilder();
		/////////////////////////////
		
		moveDisc(N, 1, 2, 3);
		System.out.println(count);
		System.out.println(sb);
	}
	
	static void moveDisc(int target, int from, int tmp, int to) {
		count++;
		
		// �������
		if (target == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}
			
		moveDisc(target-1, from, to, tmp);
		sb.append(from + " " + to + "\n");
		moveDisc(target-1, tmp, from, to);
	}
}
