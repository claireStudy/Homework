public class Solution {
    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        // memo[i] represents the maximum result for i as an input
        memo[0] = 0;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int firstPart = j;
                int anotherPart = i - j;
                int currentMax = j * Math.max(memo[anotherPart], anotherPart);
                max = Math.max(currentMax, max);
            }
            memo[i] = max;
        }
        return memo[n];
    }
}