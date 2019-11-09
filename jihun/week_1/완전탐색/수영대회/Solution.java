import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public int solution(int[][] swimmingPool, int[] startPoint, int[] endPoint, int size) {
		// 순서대로 아래, 위, 오른쪽, 왼쪽
		int[][] flags = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		boolean[][] visited = new boolean[size][size];
		int answer = -1;
		int level = 0;
		
		int startX = startPoint[0];
		int startY = startPoint[1];
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(startPoint);
		visited[startX][startY] = true;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int s=0; s<qSize; s++) {
				int[] point = (int[]) q.poll();
				if((point[0] == endPoint[0]) && (point[1] == endPoint[1])) answer = level;
				
				for(int i=0; i<flags.length; i++) {
					int nextX = flags[i][0] + point[0];
					int nextY = flags[i][1] + point[1];
				
					if((nextX < 0) || (nextX >= size) || (nextY < 0) || (nextY >= size)) continue;
					if(swimmingPool[nextX][nextY] == 1) continue;
					
					if(!visited[nextX][nextY]) {
						int[] movePoint = {nextX, nextY};
						q.add(movePoint);
						visited[nextX][nextY] = true;
					}
				}
			}
			level+=1;
		}	
		
		return answer;
	}
	
	public static void main(String[] args) {
		Solution swim = new Solution();
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] sizes = new int[T];
		int[] results = new int[T];
		sc.nextLine();
		
		for(int i=0; i<T; i++) {
			sizes[i] = sc.nextInt();
			sc.nextLine();
			int size = sizes[i];
			int[][] pool = new int[size][size];
			int[] startPoint = new int[2];
			int[] endPoint = new int[2];
			
			for(int j=0; j<size; j++) {
				for(int k=0; k<size; k++) {
					pool[j][k] = sc.nextInt();
				}
			}
			
			startPoint[0] = sc.nextInt();
			startPoint[1] = sc.nextInt();
			
			sc.nextLine();
			
			endPoint[0] = sc.nextInt();
			endPoint[1] = sc.nextInt();
			
			int result = swim.solution(pool, startPoint, endPoint, size);
			results[i] = result;
		}
		
		for(int i=0; i<results.length; i++) {
			System.out.println("#"+(i+1)+" "+results[i]);
		}
	}
}
