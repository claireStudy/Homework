public class Solution {
    public int lengthOfLongestSubstring(String s) {
       int max = 0;
       /* Validate the input. */
       if (s == null || s.length() == 0) {
           return max;
       }
       /* Use map to store the index of the last occurence of the character*/
       HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
       int i = 0;
       int length = 0; // Record the length of current substring
       int head = 0;
       
       while (i < s.length()) {
           char ch = s.charAt(i);
           /* If the character has occured, and it is in the current subarray, update max length, and 
           then count from the next index of the last occurrence index. If it has not occured, increment 
           the length. */
           if (map.containsKey(ch) && (i - length <= map.get(ch))) {
               max = Math.max(max, length);
               length = i - map.get(ch);
           } else {
               length++;
           }
           map.put(ch, i);
           i++;
       }

       max = Math.max(max, length);
       return max;
    }
}
