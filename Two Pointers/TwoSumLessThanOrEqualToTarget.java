/**
* Given an array of integers, find how many pairs in the array such that
* their sum is less than or equal to a specific target number.
* Please return the number of pairs.
*
* Example
* Given nums = [2, 7, 11, 15], target = 24.
* Return 5.
* 2 + 7 < 24
* 2 + 11 < 24
* 2 + 15 < 24
* 7 + 11 < 24
* 7 + 15 < 25
*
* http://www.lintcode.com/en/problem/two-sum-less-than-or-equal-to-target/
*/
public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else {
                count += right - left;
                left++;
            }
        }

        return count;
    }
}
