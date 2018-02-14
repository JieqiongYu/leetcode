/**
 * [LeetCode][633]Sum of Square Numbers
 * 
 * Given a non-negative integer c, your task is to decide whether there're 
 * two integers a and b such that a2 + b2 = c.
 * 
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 
 * Example 2:
 * Input: 3
 * Output: False
 * 
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            long b = (long) c - a * a;
            if (validSquare(b)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean validSquare(long num) {
        if (num == 1) {
            return true;
        }
        
        long start = 1;
        long end = num / 2;
        long mid = 0;
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        if (start * start == num) {
            return true;
        }
        
        if (end * end == num) {
            return true;
        }
        
        return false;
    }
}
/**
 * Complexity Analysis
 *      Time complexity : O(√clog(c)). 
 *                        Binary search taking O(log(c)) in the worst case is done 
 *                        for √c values of a.
 *      Space complexity : O(log(c)). 
 *                        Binary Search will take O(log(c)) space.
 */