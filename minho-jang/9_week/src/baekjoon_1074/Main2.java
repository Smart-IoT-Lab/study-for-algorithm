package baekjoon_1074;
// Z (�ٸ� Ǯ��)
// �⺻���� ����� �ð��ʰ��� ���Ƿ� ���ͳݿ��� ã�� �ٸ� ���

import java.util.Scanner;

public class Main2 {
	static int row;
	static int column;
	static int count = 0;
	
	public static void main(String[] args) {
		//////////////////�Է� �� �ʱ�ȭ
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		row = scanner.nextInt();
		column = scanner.nextInt();
		///////////////////////////////
		
		searchPos(N);
		System.out.println(count);
	}
	
	// 4��� �� �簢�� �� ��� �簢���� ���ϴ°�
	static void searchPos(int N) {
		int size = (int) Math.pow(2, N);
		
		if(size == 1) 
			return;
		
		// 1 ��и�
		if (0 <= row && row < (size/2) &&
				0 <= column && column < (size/2)) {
			count += 0 * (int) Math.pow(4, N-1);
		}
		
		// 2 ��и�
		else if (0 <= row && row < (size/2) &&
				(size/2) <= column && column < size) {
			count += 1 * (int) Math.pow(4, N-1);
			column = column - size/2;
		}
		
		// 3 ��и�
		else if ((size/2) <= row && row < size &&
				0 <= column && column < (size/2)) {
			count += 2 * (int) Math.pow(4, N-1);
			row = row - size/2;
		}
		
		// 4 ��и�
		else if ((size/2) <= row && row < size &&
				(size/2) <= column && column < size) {
			count += 3 * (int) Math.pow(4, N-1);
			row = row - size/2;
			column = column - size/2;
		}
		
		searchPos(N-1);
	}
}
