/**
 * [LeetCode][300]Longest Increasing Subsequence
 *  
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * https://leetcode.com/problems/longest-increasing-subsequence/solution/
 */
/**
 * Solution:
 * Dynamic Programming:
 *  dp[i] represents the length of LIS possible considering the array elements upto the ith index only. 
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        
        for (int i = 1; i < nums.length; i++) {
            int maxValue = 0;
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxValue = Math.max(maxValue, dp[j]);
                }
            }
            dp[i] = maxValue + 1;
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
/**
 * Time Complexity: O(n2). Two loops of n are there.
 * Space Complexity: O(n). dp array of size n is used. 
 */