/**
 * [LeetCode][26]Remove Duplicates from Sorted Array.
 * 
 * Given a sorted array, remove the duplicates in-place such that each element appear 
 * only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the 
 * input array in-place with O(1) extra memory.
 * 
 * Example:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 
 * respectively.
 * It doesn't matter what you leave beyond the new length.
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }
}