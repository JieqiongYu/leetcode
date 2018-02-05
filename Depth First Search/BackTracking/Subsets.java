/**
 * Given a set of distinct integers, nums, 
 * return all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
 * https://leetcode.com/problems/subsets/description/
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> subset = new ArrayList<>();
        dfs(results, subset, nums, 0);
        return results;
    }
    
    private void dfs(List<List<Integer>> results, List<Integer> subset, int[] nums, int startIndex) {
        results.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(results, subset, nums, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}