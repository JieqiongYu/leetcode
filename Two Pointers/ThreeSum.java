/**
* Given an array S of n integers, are there elements a, b, c in S
* such that a + b + c = 0? Find all unique triplets in the array
* which gives the sum of zero.
*
* Note: The solution set must not contain duplicate triplets.
*
* For example, given array S = [-1, 0, 1, 2, -1, -4],
*
* A solution set is:
* [
*   [-1, 0, 1],
*   [-1, -1, 2]
* ]
*
* https://leetcode.com/problems/3sum/description/
*/
/**
* Solution:
* The idea is to sort an input array and then run through all indices of a possible
* first element of a triplet.
* For each possible first element we make a standard bi-directional 2Sum sweep of
* the remaining part of the array. Also we want to skip equal elements to avoid duplicates
* in the answer without making a set or something like that.
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int left = i+1;
            int right = nums.length - 1;
            twoSum(nums, left, right, target, result);
        }

        return result;
    }

    private void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> result) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                result.add(triple);
                left++;
                right--;

                while (left < right && nums[left] == nums[left-1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right+1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
