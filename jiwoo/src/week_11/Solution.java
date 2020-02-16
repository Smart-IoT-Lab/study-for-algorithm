package week_11;
import java.util.ArrayList;

public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        int m = arr2[0].length;
        int a = 0;
        int b = 0;
        for(int i=0;i<arr1.length;i++){

            for(int j=0;j<arr2[0].length;j++){
                int sum = 0;
                for(int k=0;k<arr2.length;k++){
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[a][b%m] = sum;

                b += 1;
            }
            a++;
        }
        for(int i=0;i<answer.length;i++){
            for(int j=0;j<answer[0].length;j++)
                System.out.println(answer[i][j]);
        }
        return answer;
    }
    public static void main(String[] args){
        int[][] ans1 = {{1,4},{3,2},{4,1}};
        int[][] ans2 = {{3,3},{3,3}};
        new Solution().solution(ans1,ans2);
    }
}
