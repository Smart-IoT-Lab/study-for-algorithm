package baekjoon_11053;
// ���� �� �����ϴ� �κ� ����

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	int[] memo;
	int size;
	int[] input;
	
	int solution(int size, int[] input) {
		int answer = 0;
		
		///////// �ʱ�ȭ
		this.size = size;
		this.input = input;
		
		memo = new int[size];
		Arrays.fill(memo, 1);
		/////////////////
		
		int max = 0;
		int n;
		// ������ �ε����� �������� ���� �����ϹǷ� �ε��� ���� nextBigger�� ȣ��������
		// memo�� �ִٸ� nextBigger�� ȣ������ �ʴ´�.
		for (int i=0; i<size; i++) {
			if (memo[i] != 1)
				n = memo[i];
			else
				n = nextBigger(i);
			
			// �� �ε��� ������ �� �� ���� ū ���� ����
			if (max < n)
				max = n;
		}
		
		// memo�� ����Ǵ� �� Ȯ��
		for(int i : memo)
			System.out.print(i + " ");
		System.out.println();
		
		answer = max;
		return answer;
	}
	
	// ���� �ε������� �ڿ� ������ LIS�� ���� �ִ밪�� ����
	int nextBigger(int index) {
		int length = 1;
		int maxLength = length;
		
		// �̹� ���� ���� �Ѿ
		if (memo[index] != 1)
			return memo[index];
		
		for (int i=index+1; i<size; i++) {
			// ���� �ε����κ��� �ڿ� ���ð����� ��Ұ� �ִٸ� ���ȣ��. ��������(+1)
			if (input[index] < input[i])
				length = nextBigger(i)+1;
			
			// ���ð����� ��� �߿��� ���ϵ� �� �� ���̰� �� ���� ����.
			if (maxLength < length)
				maxLength = length;
		}
		
		// �ش� �ε����� ���� ���� ����
		if (memo[index] == 1)
			memo[index] = maxLength;
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] input = new int[size];
		for (int i=0; i<size; i++)
			input[i] = scanner.nextInt();
		
		System.out.println(m.solution(size, input));
	}
}
