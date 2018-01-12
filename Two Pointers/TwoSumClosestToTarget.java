/**
 * Given an array nums of n integers, find two integers in nums such that 
 * the sum is closest to a given number, target.
 * 
 * Return the difference between the sum of the two integers and the target.
 * 
 * http://www.lintcode.com/en/problem/two-sum-closest-to-target/
 */
public class Solution {
    /*
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                diff = Math.min(diff, target - nums[left] - nums[right]);
                left++;
            } else {
                diff = Math.min(diff, nums[left] + nums[right] - target);
                right--;
            }
        }
        
        return diff;
    }
}