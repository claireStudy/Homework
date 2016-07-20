public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0; 
        
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i + coins[j] <= amount) {
                    if (memo[i] != Integer.MAX_VALUE) {
                        memo[i + coins[j]] = Math.min(memo[i + coins[j]], memo[i] + 1);
                    }
                }
            }
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}