/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * 
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * 
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * 
 * https://leetcode.com/problems/max-consecutive-ones/description/
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int end = 0;
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                start = i + 1;
            }
            end++;
            result = Math.max(end - start, result);
        }
        
        return result;
    }
}