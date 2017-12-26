/**
* Given a set of candidate numbers (C) (without duplicates) and a target number (T),
* find all unique combinations in C where the candidate numbers sums to T.
*
* The same repeated number may be chosen from C unlimited number of times.
*
* Note:
* All numbers (including target) will be positive integers.
* The solution set must not contain duplicate combinations.
* For example, given candidate set [2, 3, 6, 7] and target 7,
* A solution set is:
* [
*   [7],
*   [2, 2, 3]
* ]
*
* https://leetcode.com/problems/combination-sum/description/
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (sum > target) {
                break;
            }
            combination.add(candidates[i]);
            dfs(candidates, i, result, combination, sum + candidates[i], target);
            combination.remove(combination.size() - 1);
        }
    }
}
