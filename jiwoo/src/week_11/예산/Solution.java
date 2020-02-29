package week_11.예산;
import java.util.Arrays;

public class Solution {
    int[] budgets;

    public int sumAll(int limit) {
        int sum = 0;
        for (int i = 0; i < budgets.length; i++) {
            if (budgets[i] > limit)
                sum += limit;
            else
                sum += budgets[i];
        }
        return sum;
    }

    public int solution(int[] budgets, int M) {
        this.budgets = budgets;
        long sum = 0;
        for (int i : budgets)
            sum += i;

        int mid = 0;

        Arrays.parallelSort(budgets);
        if (sum > M) {

            /*for (int i = 0; i < budgets.length; i++)
                System.out.println(budgets[i]);
            */

            int left = 0, right = budgets[budgets.length - 1];
            int a = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                a = sumAll(mid);
                System.out.println(mid + "에서 합계는" + a);
                if (a > M)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            
            if (a > M)
                return mid - 1;
            else
                return mid;
        }

        return budgets[budgets.length - 1];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] budgets = { { 300, 300, 300, 300 },
                { 100, 100, 100, 100 },
                { 50, 50, 150, 150 },
                { 0, 0, 300, 300 },
                { 99, 99, 99, 99 },
                { 120, 120, 90, 80 }
        };
        int[] M = { 400, 400, 400, 400, 400, 400 };
        for (int i = 0; i < budgets.length; i++)
            System.out.println(new Solution().solution(budgets[i], M[i]));
    }

}
