public class Solution {
    public int getMoneyAmount(int n) {
         if (n == 1) {
            return 0;
        }
        // memo[i][j]: minimum number of money to guarantee win for subproblem [i, j]
        int[][] memo = new int[n + 1][n + 1];
        // range : j - i
        for (int range = 1; range < n; range++) {
            for (int i = 0; i + range <= n; i++) {
                int j = i + range;
                memo[i][j] = Integer.MAX_VALUE;
                // k represents the guessing number
                // if k is not in range i ~ j, result should be 0
                for (int k = i; k <= j; k++) {
                    memo[i][j] = Math.min(memo[i][j],
                                        k + Math.max(k - 1 >= i ? memo[i][k - 1] : 0,
                                                     j >= k + 1 ? memo[k + 1][j] : 0));
                }
            }
        }
        return memo[1][n];
    }
}