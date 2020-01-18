package week_10;
import java.util.*;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people); //배열 오름차순 정렬

        int i=0;
        for(int j=people.length-1;j>=i;j--){
            if(i==j) {
                answer++;
                break;
            }
            if(people[i]+people[j]<=limit){
                i++;
                answer++;
            }
            else
                answer++;
        }
        return answer;

    }
    public static void main(String[] args){
        int[] people = {70,80,50,50, 60, 100};
        System.out.println(new Solution().solution(people,110));
    }
}