package algorithm.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 삼성 sw 제출시에는 Solution 클래스로 제출 해야 함
//public class Solution {
public class SwimmingPool {
	
	private boolean inRange(int nextX, int nextY, int poolSize)
	{
		if ((0 > nextX) || (nextX >= poolSize) || (0 > nextY) || (nextY >= poolSize))
			return false;
		else
			return true;
	}
	
	public int solution(int[][] swimmingPool, int[] startPosition, int[] endPosition, int poolSize)
	{
		int[] swimDown = {1, 0};
		int[] swimUp = {-1, 0};
		int[] swimLeft = {0, -1};
		int[] swimRight = {0, 1};
		
		int[][] moveMent = {swimDown, swimUp, swimLeft, swimRight};
		boolean[][] visited = new boolean[poolSize][poolSize];
		
		int answer = -1;
		int depth = 0;
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(startPosition);
		visited[startPosition[0]][startPosition[1]] = true;
		
		while(!q.isEmpty())
		{
			int qSize = q.size();
			for(int i = 0; i < qSize; i++)
			{
				int[] currentPosition = q.poll();
				if((currentPosition[0] == endPosition[0]) && (currentPosition[1] == endPosition[1]))
					answer = depth;
				for(int j = 0; j < moveMent.length; j++)
				{
					int nextX = moveMent[j][1] + currentPosition[0];
					int nextY = moveMent[j][0] + currentPosition[1];
					if(!this.inRange(nextX, nextY, poolSize))
						continue;
					if(swimmingPool[nextX][nextY] == 1)
						continue;
					if(!visited[nextX][nextY])
					{
						int[] nextPosition = {nextX, nextY};
						q.add(nextPosition);
						visited[nextX][nextY] = true;
					}
				}
			}
			depth += 1;
		}
		return answer;
	}
	
	public static void main(String[] args) 
	{
		// Solution swimmer = new solution();
		SwimmingPool swimmer = new SwimmingPool();
		
		// InputStreamReader inputStream = new InputStreamReader(System.in);
		Scanner sc = new Scanner(System.in);

		//테스트 케이스 읽고 다음 줄
		int testCase = sc.nextInt();
		sc.nextLine();
		
		//결과 저장 용도
		int[] results = new int[testCase];		
		
		for(int i = 0; i < testCase; i ++)
		{
			int poolSize = sc.nextInt();
			int[][] swimmingPool = new int[poolSize][poolSize];
			sc.nextLine();
			for (int j = 0; j <poolSize; j++)
			{
				for (int k = 0; k< poolSize; k++)
				{
					swimmingPool[j][k] = sc.nextInt();
				}
			}
			sc.nextLine();
			int[] startPosition = new int[2];
			startPosition[0] = sc.nextInt();
			startPosition[1] = sc.nextInt();
			
			sc.nextLine();
			int[] endPosition = new int[2];
			endPosition[0] = sc.nextInt();
			endPosition[1] = sc.nextInt();
			
			results[i] = swimmer.solution(swimmingPool, startPosition, endPosition, poolSize);
		}
		
		for(int i = 0; i< testCase; i++)
		{
			System.out.println("#"+(i+1)+" "+results[i]);
		}

	}
}