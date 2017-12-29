/**
* Given a collection of integers that might contain duplicates, nums,
* return all possible subsets (the power set).
*
* Note: The solution set must not contain duplicate subsets.
*
* For example,
* If nums = [1,2,2], a solution is:
*
* [
*   [2],
*   [1],
*   [1,2,2],
*   [2,2],
*   [1,2],
*   []
* ]
*
* https://leetcode.com/problems/subsets-ii/description/
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, result, subset, 0);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> subset, int startIndex) {
        result.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            dfs(nums, result, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}
