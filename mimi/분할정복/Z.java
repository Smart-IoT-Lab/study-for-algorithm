import java.util.*;

public class Z {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		int cnt=0,result=0;
		int div=(int) Math.pow(2, n);//n=3¿œ∂ß 8
		
		for(int i=0;i<n;i++) {
			div/=2;//4∞°µ 
			if(r<div && c<div) {
				cnt=1;
			}
			else if(r<div && c>=div) {
				cnt=2;
			}
			else if(r>=div && c<div) {
				cnt=3;
			}
			else if(r>=div && c>=div) {
				cnt=4;
			}
			
			r%=div;
			c%=div;
			
			result+=div*div*(cnt-1);
			
		}
		System.out.println(result);
	}

}
