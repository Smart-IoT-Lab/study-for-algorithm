package week_15.H_index;
import java.util.Arrays;
public class Solution {
    /*
     * [42,22,3] => 3
        [42,22,1] => 2
        [42,22,2] => 2
        [42,5,4,1] =>>3
     */
    public int solution(int[] citations) {
        int idx = 1;
        int ref = 0;
        Arrays.parallelSort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            ref = citations[i];
            //System.out.println(idx+"번째 탐색");
            // ref 기준
            if (idx >= ref) {
                //System.out.println("ref 에 따라서 정해짐");
                return ref;
            }
            // idx 기준
            else if(i!=0 && idx > citations[i-1]){
                //System.out.println("idx:"+idx+"에 따라서 정해짐");
                return idx;
            }
            else if(i==0) {
                // idx가 마지막까지갈때동안 ref보다 크지 못했을때
                // 즉 배열의 최소값이 배열의 사이즈보다 작을 때
                return citations.length;
            }
            idx += 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] numbers = { 42,22};
        System.out.println(new Solution().solution(numbers));
    }
}
