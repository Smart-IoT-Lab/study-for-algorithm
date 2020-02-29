package group_picture;

import java.util.*;

public class Solution {
	ArrayList<StringBuilder> cases = new ArrayList<>();
    
    public int solution(int n, String[] data) {
        int answer = 0;

        // 사진 찍는 사람들
        String[] peopleArr = {"A", "C", "F", "J", "M", "N", "R", "T"};

        // array to ArrayList
        ArrayList<String> people = new ArrayList<>();
        for (String s : peopleArr)
            people.add(s);
        
        // 8! = 40,320 개의 경우의 수
        // 모든 경우의 수에 대한 메모리 = 40,230 * 8 = 322,560 B = 322 KB = 0.3 MB
        // 모든 경우의 수를 저장
        createCase(people, new StringBuilder(""));
        
        // System.out.println("TEST size of the case list : " + cases.size());  // print 40320
        

        // Condition 클래스 생성
        ArrayList<Condition> conditionList = new ArrayList<>();
        for (String s : data) {
            conditionList.add(new Condition(s));
        }
        
        // 하나하나 조건 검사
        for (StringBuilder sb : cases) {
            boolean isOK = true;
            for (Condition c : conditionList) {
                if (! c.isPass(sb)) {
                    isOK = false;
                }
            }
            
            if (isOK)
            	answer++;
        }

        return answer;
    }
    
    void createCase(ArrayList<String> leftPeople, StringBuilder picture) {
        // 모두 사진 속에 자리 잡았어
        if (leftPeople.isEmpty()) {
            cases.add(picture);
            // System.out.println("case is added: " + picture.toString());
        } else {
            for (String s : leftPeople) {
            	StringBuilder tempPicture = new StringBuilder(picture);
                ArrayList<String> tempLeftPeople = (ArrayList<String>) leftPeople.clone();

                tempPicture.append(s);
                tempLeftPeople.remove(s);
                
                createCase(tempLeftPeople, tempPicture);
            }
        }
    }
    
    class Condition {
        char start;
        char end;		
        char c;			// 부등호
        int between;
        String origin;
        
        Condition(String s) {
            start = s.charAt(0);
            end = s.charAt(2);
            c = s.charAt(3);
            between = s.charAt(4) - '0';
            origin = s;
        }
        
        boolean isPass(StringBuilder sb) {
        	int diff = Math.abs(sb.indexOf(String.valueOf(start)) - sb.indexOf(String.valueOf(end))) - 1;
        	
            if (c == '=') {
                return diff == between;
            } else if (c == '>') {
                return diff > between;
            } else if (c == '<') {
                return diff < between;
            } else 
            	return false;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();

		// return 3648
		int n = 2;
		String[] data = { "N~F=0", "R~T>2" };

		// return 0
//		int n = 2;
//		String[] data = {"M~C\<2", "C~M>1"};
		
		// TEST
//		int n = 1;
//		String[] data = {"A~C=0"};

		System.out.println(s.solution(n, data));
	}
}
