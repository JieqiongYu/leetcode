/**
 * 
 * [LeetCode][238]Product of Array Except Self.
 * 
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is 
 * equal to the product of all the elements of nums except nums[i].
 * 
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space 
 * for the purpose of space complexity analysis.)
 * 
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }
        
        int[] result = new int[nums.length];
        int runningLeft = 1;
        int runningRight = 1;
        
        for (int i = 0; i < nums.length; i++) {
            result[i] = runningLeft;
            runningLeft *= nums[i];
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= runningRight;
            runningRight *= nums[i];
        }
        
        return result;
    }
}