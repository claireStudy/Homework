public class Solution {
    public int maxProduct(int[] nums) {
        /* memo[i] represents the max product ended with i*/ 
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maxMemo = new int[nums.length];
        int maxProduct = nums[0];
        maxMemo[0] = nums[0];
        int[] minMemo = new int[nums.length];
        minMemo[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxMemo[i] = Math.max(nums[i], maxMemo[i - 1] * nums[i]);
                minMemo[i] = Math.min(nums[i], minMemo[i - 1] * nums[i]);
            } else {
                maxMemo[i] = Math.max(nums[i], minMemo[i - 1] * nums[i]);
                minMemo[i] = Math.min(nums[i], maxMemo[i - 1] * nums[i]);
            }
            maxProduct = Math.max(maxProduct, maxMemo[i]);
        }
        return maxProduct;
    }
}