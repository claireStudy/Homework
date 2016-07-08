public class Solution {
    public double myPow(double x, int n) {
        // absolute value may cause overflow
        long number = Math.abs((long) n); 
        double result = 1;
        while (number > 0) {
            if (number % 2 == 1) {
                result *= x;
            }
            number >>= 1;
            x *= x;
        }
        return n > 0 ? result : 1 / result;
    }
}