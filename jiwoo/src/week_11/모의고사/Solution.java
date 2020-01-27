package week_11.모의고사;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public int[] solution(int[] answers){
        int score1=0,score2=0,score3=0;
        int[] std1 = {1,2,3,4,5};
        int[] std2 = {2,1,2,3,2,4,2,5};
        int[] std3 = {3,3,1,1,2,2,4,4,5,5};
        int len1 = std1.length;
        int len2 = std2.length;
        int len3 = std3.length;
        int idx=0;
        int max = 0;
        for (int ans:answers) {
            if(ans==std1[idx%len1]) {
                score1++;
                if(score1>max)
                    max = score1;
            }
            if(ans==std2[idx%len2]) {
                score2++;
                if(score2>max)
                    max = score2;
            }
            if(ans==std3[idx%len3]) {
                score3++;
                if(score3>max)
                    max = score3;
            }
            idx++;
        }
        System.out.println(score1+","+score2+","+score3);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(score1==max)
            arr.add(1);
        if(score2==max)
            arr.add(2);
        if(score3==max)
            arr.add(3);
        int[] str = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            str[i] = arr.get(i).intValue();
            System.out.println(str[i]);
        }
        return str;
    }
    public static void main(String[] args){
        int[] ans = {1,3,2,4,2};
        new Solution().solution(ans);
    }
}
