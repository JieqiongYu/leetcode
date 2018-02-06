/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping 
 * you from robbing each of them is that adjacent houses have security system connected 
 * and it will automatically contact the police if two adjacent houses were broken into 
 * on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * https://leetcode.com/problems/house-robber/description/
 */
/**
 * Solution
 *  f(k) = max(f(k-2) + Ak, f(k-1))
 */
class Solution {
    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;

        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }

        return currMax;
    }
}
/**
 * Complexity Analysis
 *  Time Complexity: O(n). Assume that n is the number of houses, the time complexity is O(n). 
 *  Space Complexity: O(1). 
 */