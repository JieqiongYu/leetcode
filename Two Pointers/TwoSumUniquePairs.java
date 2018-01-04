/**
* Given an array of integers, find how many unique pairs in the array such that
* their sum is equal to a specific target number. Please return the number of pairs.
*
* Example
* Given nums = [1,1,2,45,46,46], target = 47
* return 2
*
* 1 + 46 = 47
* 2 + 45 = 47
* 
* http://www.lintcode.com/en/problem/two-sum-unique-pairs/
*/
public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                count++;
                left ++;
                right--;
                while (left < right && nums[left] == nums[left-1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right+1]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
