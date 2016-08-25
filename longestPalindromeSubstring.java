public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String result = "";
        int maxLen = 0;
        // dp[i][j] represents the substring(i, j + 1) is a palindrome or not
        boolean[][] dp = new boolean[len][len];
        if (s == null || len == 0) {
            return s;
        }
        // l is the length of the substring, i is the starting point, j is the ending point
        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    // dupdate the max length and max string
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }
}