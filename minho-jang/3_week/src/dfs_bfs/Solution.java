package dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        for (int start = 0; start < n; start++) {
        	// 방문한적 있으면 건너뛰어
        	if(visited[start])
        		continue;
        	
            q.add(start);
            visited[start] = true;
            
            while(!q.isEmpty()) {
            	
            	start = q.poll();
            	for (int i = 0; i < n; i++) {
            		if (start != i && computers[start][i] == 1 && !visited[i]) {
            			q.add(i);
            			visited[i] = true;
            		}
            	}
            }
            
            // 여기까지 왔다면 하나의 네트워크가 있다는 증거
            answer++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {
				{1,1,0},
				{1,1,1},
				{0,1,1}
		};
		
		Solution s = new Solution();
		System.out.println(s.solution(n, computers));
	}
}
