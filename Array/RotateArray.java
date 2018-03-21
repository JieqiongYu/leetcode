/**
 * [LeetCode][189] Rotate Array.
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] 
 * is rotated to [5,6,7,1,2,3,4].
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 
 * 3 different ways to solve this problem.
 * 
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Related problem: Reverse Words in a String II
 * 
 * https://leetcode.com/problems/rotate-array/description/
 */
/**
 * Solution:
 * As in Example:
 * Original List: [1,2,3,4,5,6,7]
 * Reverse all: [7,6,5,4,3,2,1]
 * Reverse first k: [5,6,7,4,3,2,1]
 * Reverse last n-k: [5,6,7,1,2,3,4] --> Result
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        k %= nums.length;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}