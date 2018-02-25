/**
 * [LeetCode][287]Find the Duplicate Number.
 * 
 * Given an array nums containing n + 1 integers where each integer is 
 * between 1 and n (inclusive), prove that at least one duplicate number 
 * must exist. Assume that there is only one duplicate number, 
 * find the duplicate one.
 * 
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * 
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }
}
/**
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */