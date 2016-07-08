public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int start = 0, end = citations.length - 1, result = 0, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (citations[mid] < citations.length - mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return citations.length - start;
    }
}