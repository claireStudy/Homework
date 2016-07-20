public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (prices == null || len == 0) {
            return 0;
        }
        int[] buy = new int[len + 1];
        int[] sell = new int[len + 1];
        int[] rest = new int[len + 1];
        buy[0] = Integer.MIN_VALUE;
        
        for (int i = 1; i < len + 1; i++) {
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i - 1], sell[i - 1]);
            rest[i] = Math.max(sell[i - 1], Math.max(buy[i - 1], rest[i - 1]));
        }
        return Math.max(buy[len], Math.max(sell[len], rest[len]));
    }
}