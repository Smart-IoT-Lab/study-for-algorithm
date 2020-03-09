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
            if (idx >= ref || idx <= ref)
                return ref;
            idx = idx + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] numbers = { 5, 0 };
        System.out.println(new Solution().solution(numbers));
    }
}
