package algorithmStudy.week9;

import java.util.Scanner;

public class HanoiTower {
	
	public static int answer = 0;
	public static StringBuilder sb = new StringBuilder();
	
	public void moveStencil(int numOfStencil, int startingPoint, int waypoint1, int destination) {
		
		if(numOfStencil == 0) {
			return;
		}
		moveStencil(numOfStencil - 1, startingPoint, destination ,waypoint1);
		sb.append(startingPoint + " " + destination + "\n");
		moveStencil(numOfStencil - 1, waypoint1, startingPoint, destination);
		answer++;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HanoiTower hanoiTowerAgent = new HanoiTower();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoiTowerAgent.moveStencil(N, 1, 2, 3);
		
		System.out.println(answer);
		System.out.println(sb);
	}

}
