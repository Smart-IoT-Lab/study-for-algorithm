package week_13.비밀지도;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            //첫번째. arr1과 arr2의 첫번째 숫자를 이진수로 변환
            //한번씩 나누면서 or계산 후 or 연산
            char[] str = new char[n];
            int remainder1 = -1;
            int remainder2 = -1;
            int tmp1 = arr1[i]; //9
            int tmp2 = arr2[i]; //30

            int cnt = n;
            while (cnt != 0) {
                cnt--;
                if (tmp1 == 0) {
                    remainder1 = 0;
                } else {
                    remainder1 = tmp1 % 2;
                    tmp1 = tmp1 / 2;
                }
                if (tmp2 == 0) {
                    remainder2 = 0;
                } else {
                    remainder2 = tmp2 % 2;
                    tmp2 = tmp2 / 2;
                }

                //System.out.println(remainder1 + "||" + remainder2);
                if (remainder1 == 1 || remainder2 == 1) {
                    str[cnt] = '#';
                } else {
                    str[cnt] = ' ';
                }
            }
            //System.out.println(str);
            answer[i] = String.valueOf(str);
        }
        return answer;
    }
    public static void main(String[] args){
        int[] test1 = {9,20,28,18,11};
        int[] test2 = {30,1,21,17,28};
        new Solution().solution(5,test1,test2);
    }
}
