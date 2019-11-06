package exhaustive_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution_SwimmingContest {

	final int poolScale;
	final int[][] pool;
	final int[] start, end;
	
	ArrayList<ArrayList<int[]>> allPath;
	
	Solution_SwimmingContest(int poolScale, int[][] pool, int[] start, int[] end) {
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
		
		answer = Collections.min(pathSize) - 1;
		return answer;
	}
	
	void swim(int[] pos, ArrayList<int[]> path) {
		System.out.println("TEST pos : " + pos[0] + ", " + pos[1]);
		
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
				if (direction.equals("left")) {
					newPos = newPosLeft;
					childPath.add(newPos);
					// ���� �߰��� ��ġ�� ���̸�
					if (equalsPos(newPos, end))
						allPath.add(childPath);
					else
						swim(newPos, childPath);
				}
				
				if (direction.equals("right")) {
					newPos = newPosRight;
					childPath.add(newPos);
					// ���� �߰��� ��ġ�� ���̸�
					if (equalsPos(newPos, end))
						allPath.add(childPath);
					else
						swim(newPos, childPath);
				}
				
				if (direction.equals("up")) {
					newPos = newPosUp;
					childPath.add(newPos);
					// ���� �߰��� ��ġ�� ���̸�
					if (equalsPos(newPos, end))
						allPath.add(childPath);
					else
						swim(newPos, childPath);
				}
				
				if (direction.equals("down")) {
					newPos = newPosDown;
					childPath.add(newPos);
					// ���� �߰��� ��ġ�� ���̸�
					if (equalsPos(newPos, end))
						allPath.add(childPath);
					else
						swim(newPos, childPath);
				}
			}
			
		} else if (swimDirection.size() == 1) {	// ������ 1�� �̸� �׳� path�� ����.
			Iterator<String> it = swimDirection.iterator();
			int[] newPos = null;
			
			while (it.hasNext()) { 
				String direction = it.next();
				if (direction.equals("left")) {
					newPos = newPosLeft;
					path.add(newPos);
					// ���� �߰��� ��ġ�� ���̸�
					if (equalsPos(newPos, end))
						allPath.add(path);
					else
						swim(newPos, path);
				}
				
				if (direction.equals("right")) {
					newPos = newPosRight;
					path.add(newPos);
					// ���� �߰��� ��ġ�� ���̸�
					if (equalsPos(newPos, end))
						allPath.add(path);
					else
						swim(newPos, path);
				}
				
				if (direction.equals("up")) {
					newPos = newPosUp;
					path.add(newPos);
					// ���� �߰��� ��ġ�� ���̸�
					if (equalsPos(newPos, end))
						allPath.add(path);
					else
						swim(newPos, path);
				}
				
				if (direction.equals("down")) {
					newPos = newPosDown;
					path.add(newPos);
					// ���� �߰��� ��ġ�� ���̸�
					if (equalsPos(newPos, end))
						allPath.add(path);
					else
						swim(newPos, path);
				}
			}
		} else {		// �� �� �ִ� ������ ����.
			return;
		}
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
		// TEST 2 > answer: 6
//		int poolScale = 5;
//		int[][] pool = {
//				{0, 0, 0, 1, 0},
//				{0, 1, 0, 0, 0},
//				{0, 0, 1, 1, 0},
//				{1, 0, 0, 0, 0},
//				{0, 0, 1, 0, 0}};
//		int[] start = {4, 0};
//		int[] end = {2, 4};
		
		// TEST 3 > answer: 8
//		int poolScale = 6;
//		int[][] pool = {
//				{0, 0, 1, 0, 0, 1},
//				{0, 0, 1, 0, 0, 1},
//				{0, 0, 0, 0, 0, 0},
//				{0, 0, 0, 0, 1, 0},
//				{1, 1, 1, 1, 1, 1},
//				{1, 1, 1, 1, 1, 1}};
//		int[] start = {0, 0};
//		int[] end = {3, 5};
		
		// TEST 4 > 14
		int poolScale = 5;
		int[][] pool = {
				{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 1, 1, 0},
				{0, 0, 0, 0, 0}};
		int[] start = {4, 0};
		int[] end = {2, 0};
		
		Solution_SwimmingContest test = new Solution_SwimmingContest(poolScale, pool, start, end);
		System.out.println(test.solution());
		
		
		
		
	}
}
