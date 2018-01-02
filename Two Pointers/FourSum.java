/**
* Given an array S of n integers, are there elements a, b, c, and d in S
* such that a + b + c + d = target? Find all unique quadruplets in the array
* which gives the sum of target.
*
* Note: The solution set must not contain duplicate quadruplets.
*
* For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
* A solution set is:
* [
*   [-1,  0, 0, 1],
*   [-2, -1, 1, 2],
*   [-2,  0, 0, 2]
* ]
* 
* https://leetcode.com/problems/4sum/description/
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i-1] == nums[i]) {
                continue;
            }
            for (int j = i+1; j < nums.length - 2; j++) {
                if (j != i+1 && nums[j-1] == nums[j]) {
                    continue;
                }
                int left = j+1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> quadruplets = new ArrayList<>();
                        quadruplets.add(nums[i]);
                        quadruplets.add(nums[j]);
                        quadruplets.add(nums[left]);
                        quadruplets.add(nums[right]);
                        result.add(quadruplets);
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left-1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right+1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
