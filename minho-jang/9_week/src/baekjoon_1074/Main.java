package baekjoon_1074;
// Z
// ��Ȯ���� �´°� ������ �ð��ʰ�

import java.util.*;

public class Main {
	static int row;
	static int column;
	static int count = 0;

	public static void main(String[] args) {
		////////////////// �Է� �� �ʱ�ȭ
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		row = scanner.nextInt();
		column = scanner.nextInt();
		///////////////////////////////

		int[] start = { 0, 0 };
		visitZ(N, start);
	}

	static void visitZ(int size, int[] start) {

		if (size == 0) {
			if (start[0] == row && start[1] == column) {
				System.out.println(count);
				System.exit(0);
			}
			count++;

			return;
		}

		// Z ������� �湮
		visitZ(size - 1, start);
		visitZ(size - 1, next(1, size, start));
		visitZ(size - 1, next(2, size, start));
		visitZ(size - 1, next(3, size, start));
	}

	static int[] next(int idx, int size, int[] start) {
		int[][] posList = { 
				start,
				{ start[0] + 0, start[1] + (int) Math.pow(2, size - 1) },
				{ start[0] + (int) Math.pow(2, size - 1), start[1] + 0 },
				{ start[0] + (int) Math.pow(2, size - 1), start[1] + (int) Math.pow(2, size - 1) } };

		return posList[idx];
	}
}
