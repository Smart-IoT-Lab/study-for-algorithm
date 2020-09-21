package week_15.타겟넘버;
import java.util.Arrays;
public class Solution {
    int target = 1;

    public void combination(int[] tar, int n, int r, int index, int target, int tarIdx) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < tar.length; i++) {
                sum += tar[i];
            }
            if (sum == this.target)
                System.out.println(Arrays.toString(tar));
        } else if (target == n) {

            return;

        } else {
            tar[index] = -1 * tar[index];
            combination(tar, n, r - 1, index + 1, target + 1, tarIdx + 1);

            tar[index] = -1 * tar[index];
            combination(tar, n, r, index + 1, target + 1, tarIdx + 1);
        }
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        this.target = target;
        for (int i = 0; i < numbers.length; i++) {
            combination(numbers, numbers.length, i, 0, 0, 0);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 1, 1, 1, 1 };
        new Solution().solution(numbers, 3);
    }

}
