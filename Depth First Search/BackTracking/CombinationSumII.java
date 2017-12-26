/**
* Given a collection of candidate numbers (C) and a target number (T),
* find all unique combinations in C where the candidate numbers sums to T.
*
* Each number in C may only be used once in the combination.
*
* Note:
* All numbers (including target) will be positive integers.
* The solution set must not contain duplicate combinations.
* For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
* A solution set is:
* [
*   [1, 7],
*  [1, 2, 5],
*  [2, 6],
*  [1, 1, 6]
* ]
*
* https://leetcode.com/problems/combination-sum-ii/description/
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        dfs(candidates, 0, result, combination, 0, target);
        return result;
    }

    private void dfs(int[] candidates, int startIndex, List<List<Integer>> result,
                     List<Integer> combination, int sum, int target) {
        if (sum == target) {
            result.add(new ArrayList<Integer>(combination));
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && (candidates[i] == candidates[i - 1])) {
                continue;
            }
            if (sum > target) {
                break;
            }
            combination.add(candidates[i]);
            dfs(candidates, i+1, result, combination, sum + candidates[i], target);
            combination.remove(combination.size() - 1);
        }
    }
}
