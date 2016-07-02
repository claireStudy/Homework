public class Solution {
    public List<String> restoreIpAddresses(String s) {
        /* Validate input*/
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        StringBuilder string = new StringBuilder();
        helper(s, "", result, 0);
        return result;
    }
    
    private void helper(String s, String prefix, List<String> res, int count) {
        if (count == 3 && checkIfValid(s)) {
            res.add(prefix + s);
            return;
        }
        
        for (int i = 1; i < 4 && i < s.length(); i++) {
            String substring = s.substring(0, i);
            if (checkIfValid(substring)) {
                helper(s.substring(i), prefix + substring + '.', res, count + 1);
            }
        }
    }
    
    /* check if it is in 0 ~ 255*/
    private boolean checkIfValid(String s) {
        int value = Integer.parseInt(s);
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        return value >= 0 && value <= 255;
    }
}
