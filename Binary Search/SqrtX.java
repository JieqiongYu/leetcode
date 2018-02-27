/**
 * [LeetCode][69]Sqrt(x)
 * 
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * x is guaranteed to be a non-negative integer.
 * 
 * Example 1:
 * Input: 4
 * Output: 2
 * Example 2:
 * 
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, 
 * the decimal part will be truncated.
 * 
 * https://leetcode.com/problems/sqrtx/description/
 */
class Solution {
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int) end;
        }
        
        return (int) start;
    }
}