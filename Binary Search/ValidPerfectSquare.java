/**
 * [LeetCode][367]Valid Perfect Square
 * 
 * Given a positive integer num, write a function which returns True 
 * if num is a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * Input: 16
 * Returns: True
 * 
 * Example 2:
 * Input: 14
 * Returns: False
 * 
 * https://leetcode.com/problems/valid-perfect-square/description/
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        
        long low = 1;
        long high = num / 2;
        long mid = 0;
        long nums = (long) num;
        
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (mid * mid == nums) {
                return true;
            } else if (mid * mid < nums) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        if (low * low == nums) {
            return true;
        }
        
        if (high * high == nums) {
            return true;
        }
        
        return false;
    }
}