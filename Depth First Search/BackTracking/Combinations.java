/**
 * [LeetCode 77] Combinations
 * 
 * Given two integers n and k, return all possible combinations of k numbers 
 * out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 
 * https://leetcode.com/problems/combinations/description/
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        
        dfs(result, combination, n, k, 1);
        
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> combination, int n, int k, int start) {
        if (combination.size() == k) {
            result.add(new ArrayList<Integer>(combination));
        }
        
        for (int i = start; i <= n; i++) {
            combination.add(i);
            dfs(result, combination, n, k, i+1);
            combination.remove(combination.size() - 1);
        }
    }
}

/**
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 */