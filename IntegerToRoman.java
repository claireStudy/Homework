public class Solution {
    public String intToRoman(int num) {
        /* validate the input*/
        if (num < 1 || num > 3999) {
            return "";
        }
        /* use the hashmap to store roman characters and value pair*/
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        initializeMap(map);
        
        StringBuilder result = new StringBuilder();
        int[] array = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int pos = array.length;
        int remainder = num;
        if (map.containsKey(remainder)) {
            result.append(map.get(remainder));
            return result.toString();
        }
        
        while (remainder > 0) {
            int dividerIndex = findCharIndex(array, --pos, num); 
            int divider = array[dividerIndex];
            int frequency = remainder / divider;
            appendString(result, map.get(divider), frequency);
            remainder = remainder % divider;
        }
        return result.toString();
    }
    
    private void initializeMap(HashMap<Integer, String> map) {
        map.put(1,"I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }
    
    private void appendString(StringBuilder string, String character, int freq) {
        while (freq > 0) {
            string.append(character);
            freq--;
        }
    }
    
    private int findCharIndex(int[] array, int pos, int value) {
        int i;
        for (i = pos; i >= 0; i--) {
            if (array[i] <= value) {
                break;
            }
        }
        return i;
    }
}
