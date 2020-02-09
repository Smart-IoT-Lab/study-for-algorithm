import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
       
    	int count1[]= {1,2,3,4,5};
		int count2[]= {2,1,2,3,2,4,2,5};
		int count3[]= {3,3,1,1,2,2,4,4,5,5};
        int cnt1=0, cnt2=0 , cnt3=0,i=0;
       
        for(i=0; i <answers.length; i++) {
			if(answers[i]==count1[i%5]) {
				cnt1++;
			}
			if(answers[i]==count2[i%8]) {
				cnt2++;
			}
			if(answers[i]==count3[i%10]) {
				cnt3++;
			}
			
		}
        ArrayList<Integer> ans = new ArrayList<>();
		if(cnt1>cnt2 && cnt1>cnt3) {//cnt1이 가장 클때
			ans.add(1);
		}
		else if(cnt2>cnt1 && cnt2>cnt3) {//cnt2가 가장 클때
			ans.add(2);
		}
		else if(cnt3>cnt1 && cnt3>cnt2) {//cnt3가 가장 클때
			ans.add(3);
		}
		else if((cnt1==cnt2) && (cnt2==cnt3)) {//같을 경우
			ans.add(1);
			ans.add(2);
			ans.add(3);
		}
		else if(cnt1==cnt2 && cnt2>cnt3) {//1,2
			ans.add(1);
			ans.add(2);
			
		}
		else if(cnt2==cnt3 && cnt2>cnt1) {//2,3
			ans.add(2);
			ans.add(3);
			
		}
		else if(cnt1==cnt3 && cnt1>cnt2) {//1,3
			ans.add(1);
			ans.add(3);
			
		}
		int answer[]=new int[ans.size()];
		for(int j=0;j<ans.size();j++) {
			answer[j]=ans.get(j);
	
			
		}
        return answer;
    }
}