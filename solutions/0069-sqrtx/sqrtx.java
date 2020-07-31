// Implement int sqrt(int x).
//
// Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
//
// Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
//
// Example 1:
//
//
// Input: 4
// Output: 2
//
//
// Example 2:
//
//
// Input: 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since 
//              the decimal part is truncated, 2 is returned.
//
//


class Solution {
    /*
    public int mySqrt(int x) {
        long low = 0;
        long high = x;
        while (low<=high) {
            long mid = low + (high-low)/2;
            long mid2 = mid*mid;
            if (mid2 < x) low = mid + 1;
            else if (mid2>x) high = mid - 1;
            else return (int) mid;
        } 
        return (int)high;
    }
    
    */
    
    public  int mySqrt(int x) {
        long a = x;
        while (a*a > x) {
            a = (a + x/a) / 2;
        }
        return (int)a;
    }
}
