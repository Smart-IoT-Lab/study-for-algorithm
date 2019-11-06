package exhaustive_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	final int poolScale;
	final int[][] pool;
	final int[] start, end;
	
	ArrayList<ArrayList<int[]>> allPath;
	
	Solution(int poolScale, int[][] pool, int[] start, int[] end) {
		this.poolScale = poolScale;
		this.pool = pool;
		this.start = start;
		this.end = end;
		
		allPath = new ArrayList<ArrayList<int[]>>();
	}
	
	int solution() {
		int answer = 0;
		
		int[] pos = start;
		
		ArrayList<int[]> path = new ArrayList<>();
		path.add(pos);
		swim(pos, path);
		
		ArrayList<Integer> pathSize = new ArrayList<Integer>();
		for (ArrayList<int[]> p : allPath) 
			pathSize.add(p.size());
		
		if (pathSize.size() == 0)	return -1;
		answer = Collections.min(pathSize) - 1;
		return answer;
	}
	
	void swim(int[] pos, ArrayList<int[]> path) {
		// System.out.println("TEST pos : " + pos[0] + ", " + pos[1]);
		
		// ������ �� �ִ°�?
		Set<String> swimDirection = new HashSet<>();
		
		// ����
		int[] newPosLeft = {pos[0], pos[1]-1};
		if (!hasPos(path, newPosLeft) && newPosLeft[1] >= 0 && pool[newPosLeft[0]][newPosLeft[1]] == 0)
			swimDirection.add("left");
		// ������
		int[] newPosRight = {pos[0], pos[1]+1};
		if (!hasPos(path, newPosRight) && newPosRight[1] < poolScale && pool[newPosRight[0]][newPosRight[1]] == 0)
			swimDirection.add("right");
		// ��
		int[] newPosUp = {pos[0]-1, pos[1]};
		if (!hasPos(path, newPosUp) && newPosUp[0] >= 0 && pool[newPosUp[0]][newPosUp[1]] == 0)
			swimDirection.add("up");
		// �Ʒ�
		int[] newPosDown = {pos[0]+1, pos[1]};
		if (!hasPos(path, newPosDown) && newPosDown[0] < poolScale && pool[newPosDown[0]][newPosDown[1]] == 0)
			swimDirection.add("down");
		
		// �� �� �ִ� ������ 2�� �̻��̸� childPath ����.
		if (swimDirection.size() > 1) {
			int[] newPos = null;
			Iterator<String> it = swimDirection.iterator();
			
			while (it.hasNext()) { 
				ArrayList<int[]> childPath = new ArrayList<>();
				for (int[] i : path)
					childPath.add(i);
				
				String direction = it.next();
				if (direction.equals("left")) 
					searchNewPath(newPos, newPosLeft, childPath);
				
				if (direction.equals("right")) 
					searchNewPath(newPos, newPosRight, childPath);
	
				if (direction.equals("up")) 
					searchNewPath(newPos, newPosUp, childPath);
				
				if (direction.equals("down")) 
					searchNewPath(newPos, newPosDown, childPath);
			}
			
		} else if (swimDirection.size() == 1) {	// ������ 1�� �̸� �׳� path�� ����.
			Iterator<String> it = swimDirection.iterator();
			int[] newPos = null;
			
			while (it.hasNext()) { 
				String direction = it.next();
				if (direction.equals("left")) 
					searchNewPath(newPos, newPosLeft, path);
	
				if (direction.equals("right")) 
					searchNewPath(newPos, newPosRight, path);
				
				if (direction.equals("up")) 
					searchNewPath(newPos, newPosUp, path);

				if (direction.equals("down")) 
					searchNewPath(newPos, newPosDown, path);
			}
			
		} else {	// �� �� �ִ� ������ ����.
			return;
		}
	}
	
	void searchNewPath(int[] newPos, int[] newPosDirection, ArrayList<int[]> path) {
		newPos = newPosDirection;
		path.add(newPos);
		// ���� �߰��� ��ġ�� ���̸�
		if (equalsPos(newPos, end))
			allPath.add(path);
		else
			swim(newPos, path);
	}
	
	boolean equalsPos(int[] a, int[] b) {
		return a[0] == b[0] && a[1] == b[1];
	}
	
	boolean hasPos(ArrayList<int[]> arr, int[] pos) {
		boolean has = false;
		for (int[] p : arr) {
			if (equalsPos(p, pos))
				has = true;
		}
		return has;
	}

	public static void main(String args[]) {
		

		Scanner scanner = new Scanner(System.in);
		int caseNum = scanner.nextInt();
		HashMap<Integer, Long> time = new HashMap<>();
		int[] answer = new int[caseNum];
		
		for (int n = 0; n < caseNum; n++) {
			// read input
			int poolScale = scanner.nextInt();
			int[][] pool = new int[poolScale][poolScale];
			for (int i = 0; i < poolScale; i++) {
				for (int j = 0; j < poolScale; j++) {
					pool[i][j] = scanner.nextInt();
				}
			}
			int[] start = {scanner.nextInt(), scanner.nextInt()};
			int[] end = {scanner.nextInt(), scanner.nextInt()};
			
			// time measure
			long startTime = System.currentTimeMillis();
			Solution test = new Solution(poolScale, pool, start, end);
			answer[n] = test.solution();
			long endTime = System.currentTimeMillis();
			time.put(n+1, endTime - startTime);
		}
		
		for (int n = 0; n < caseNum; n++) {
			System.out.println("#" + (n+1) + " " + answer[n]);
			System.out.println("time: " + time.get(n+1) + "ms");
		}

	}
}
