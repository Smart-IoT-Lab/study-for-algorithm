package exhaustive_search;

import java.util.ArrayList;

class Solution_NumberBaseball {
	
	public int solution(int[][] baseball) {
    	ArrayList<int[]> numCases = new ArrayList<>();
        int answer = 0;
        
        // ��� ����� ��
        numCases = init();
        
        // �Էµ� baseball ��ŭ �ݺ�.
        for (int i = 0; i < baseball.length; i++) {
        	int compInt = baseball[i][0];
            int num1 = compInt / 100;			// 100�� �ڸ�
            int num2 = (compInt / 10) % 10;		// 10�� �ڸ�
            int num3 = compInt % 10;			// 1�� �ڸ�
            int[] compNumber = {num1, num2, num3};
            
            ArrayList<int[]> newCases = new ArrayList<int[]>();

            for (int[] number : numCases) {
            	int[] result = compare(number, compNumber);
            	
        		if (result[0] == baseball[i][1] && result[1] == baseball[i][2]) {
        			newCases.add(number);
        		}
            }
            
            // ������ ����� �� ��ü
            numCases = newCases;
        }
		
//        for (int[] result : numCases) {
//        	System.out.println("case: " + printArrNum(result));
//        }
        answer = numCases.size();
        return answer;
    }
    
    int[] compare(int[] num, int[] comp) {
    	final int numSize = 3;

    	int[] ret = {0, 0};
    	
    	boolean[] checkedNum = {false, false, false};
    	// strike �˻�
    	int strike = 0;
    	for (int i = 0; i < numSize; i++) {
    		if (num[i] == comp[i]) {
    			strike++;
    			checkedNum[i] = true;
    		}
    	}
    	
    	// ball �˻�
        int ball = 0;
    	for (int i = 0; i < numSize; i++) {
    		if (checkedNum[i])
    			continue;
    		
    		for (int j = 0; j < numSize; j++) {
    			if (num[i] == comp[j] )
    				ball++;
    		}
    	}
    	
    	ret[0] = strike;
    	ret[1] = ball;
    	
        return ret;
    }
    
    ArrayList<int[]> init() {
    	ArrayList<int[]> ret = new ArrayList<int[]>();
        
    	for (int i = 1; i < 10; i++) {
        	for (int j = 1; j < 10; j++) {
        		for (int k = 1; k < 10; k++) {
        			// �ߺ� ����.
            		if (i == j || k == j || k == i)	continue;
            		
        			int[] number = new int[3];
        			number[0] = i;
            		number[1] = j;
            		number[2] = k;
            		
            		ret.add(number);
        		}
        	}
    	}
    	
    	return ret;
    }
    
    String printArrNum (int[] num) {
    	return " " + num[0] + num[1] + num[2];
    }
    
//    public static void main(String args[]) {
//    	Solution_NumberBaseball test = new Solution_NumberBaseball();
//    	// {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}}
//    	int[][] baseball = {{123, 1, 1}, {356, 1, 0}};
//    	System.out.println(test.solution(baseball));
//    }
}