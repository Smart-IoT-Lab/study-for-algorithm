import java.util.*;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int cnt = 0;
        int[] check = new int[people.length];
        for(int i=0;i<people.length;i++){
            int min = 0;
            check[i] =1;
            for(int j=i+1;j<people.length;i++){
                if(check[j] != 0 && people[i] + people[j] <= limit && people[i] + people[j] > min){
                    check[j]=0;
                    cnt++;
                }
            }
        }

        return answer;

    }
    public static void main(String[] args){
        System.out.print(Solution({70,50,80,50},100));
    }
}