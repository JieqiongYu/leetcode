/**
* Given an array of n positive integers and a positive integer s,
* find the minimal length of a contiguous subarray of which the sum ≥ s.
* If there isn't one, return 0 instead.
*
* For example, given the array [2,3,1,2,4,3] and s = 7,
* the subarray [4,3] has the minimal length under the problem constraint.
*
* https://leetcode.com/problems/minimum-size-subarray-sum/description/
*/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = nums.length + 1;

        for (left = 0; left < nums.length; left++) {
            while (right < nums.length && sum < s) {
                sum += nums[right];
                right++;
            }

            if (sum >= s) {
                result = Math.min(result, right - left);
            }

            sum -= nums[left];
        }

        if (result == nums.length + 1) {
            return 0;
        }

        return result;
    }
}
