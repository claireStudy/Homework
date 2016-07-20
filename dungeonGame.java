public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 1;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] health = new int[row][col];
        health[row - 1][col - 1] = Math.max(1 - dungeon[row - 1][col - 1], 1);
        // initialize last column
        for (int i = row - 2; i >= 0; i--) {
            health[i][col - 1] = Math.max(health[i + 1][col - 1] - dungeon[i][col - 1], 1); 
        }
        // initialize last row
        for (int i = col - 2; i >= 0; i--) {
            health[row - 1][i] = Math.max(health[row - 1][i + 1] - dungeon[row - 1][i], 1);
        }
        
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(down, right);
            }
        }
        return health[0][0];
    }
}