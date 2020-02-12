import java.util.Scanner;

public class Hanoi {
	public static StringBuilder sb = new StringBuilder();
	int result=0;
	public static void hanoi(int k, int a, int b, int c) {
		if(k==1) {
			sb.append(a + " " + c+"\n");
		}
		else {
			hanoi(k-1, a, c, b);
			sb.append(a + " " + c+"\n");
			hanoi(k-1, b, a, c);
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int result=1;
		
		for(int i=0;i<n;i++) {
			result*=2;
		}
		
		System.out.println(result-1);
		hanoi(n,1, 2, 3);
		System.out.println(sb);
	}
}
