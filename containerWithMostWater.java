public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int water = 0;
        while (i < j) {
            int width = j - i;
            water = Math.max (water, width * Math.min(height[i], height[j]));
            // replace the shorter one: because the water amount is depending on
            // width and the shorter height. If the shorter one doesn't change,
            // it is impossible to get more water with reduced width
            if (height[i] < height[j]) {
                i++; //replace i
            } else {
                j--; //replace j
            }
        }
        return water;
    }
}