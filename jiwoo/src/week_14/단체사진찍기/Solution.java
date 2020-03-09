package week_14.단체사진찍기;
import java.util.*;

/*
모든 경우의 수 - 겹치는 조건의 수
 */
public class Solution {
    int[] fact = {0,0,0,0,0,0,0,0};
    final int peopleNum = 8;
    int factorial(int n){
        if(n==1)
            return 1;
        else if(fact[n-1]!=0) {
            return n;
        }
        return factorial(n-1)*n;
    }
    int sameCase(int targetNum,int distance){
        int sum = 0;
        sum += factorial(peopleNum-targetNum);
        sum += peopleNum-distance-targetNum+1;
        sum = factorial(targetNum);
        return sum;
    }
    int moreCase(int targetNum, int distance){
        int sum = 0;
        for(int i=distance;i<peopleNum;i++){
            sum += sameCase(targetNum,i+1);
        }
        return sum;
    }
    int lessCase(int targetNum, int distance){
        int sum = 0;
        for(int i=distance;i>=1;i--){
            sum += sameCase(targetNum,i+1);
        }
        return sum;
    }
    public int solution(int n, String[] data) {
        char target1 = 0;
        char target2 = 0;
        int distance = -1;
        int answer = 0;
        //모든 경우의 수 세기
        for(int i=0;i<n;i++){
            target1 = data[i].charAt(0);
            target2 = data[i].charAt(2);
            distance = data[i].charAt(4)-48;
            if(data[i].charAt(3)=='='){
                answer += sameCase(2,distance+1);
            }
            else if(data[i].charAt(3)=='>'){
                answer += moreCase(2,distance);
            }
            else if(data[i].charAt(3)=='<'){
                answer += lessCase(2,distance);
            }
        }

        //겹치는 경우의 수 세기
        for(int i=0;i<n-1;i++){
            int cnt = 4;
            ArrayList<Integer> targets = new ArrayList<>();
            targets.add(data[i].charAt(0)-48);
            targets.add(data[i].charAt(2)-48);
            if(targets.indexOf(data[i+1].charAt(0)-48)!=-1){
                cnt--;
            }
            if(targets.indexOf(data[i+1].charAt(2)-48)!=-1){
                cnt--;
            }
            if(cnt==2){
                return -2;
            }
            else{

            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] n = { 3 };
        int[][] arr = { { 1, 1, 1, 1, 1 } };
        for (int i = 1; i <= 8; i++)
            System.out.println(new Solution().factorial(i));
    }
}
