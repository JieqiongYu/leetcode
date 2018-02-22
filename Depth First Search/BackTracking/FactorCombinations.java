/**
 * [LeetCode][254]Factor Combinations
 * 
 * Numbers can be regarded as product of its factors. For example,
 * 8 = 2 x 2 x 2;
 *  = 2 x 4
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * 
 * Note: 
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Examples: 
 * input: 1
 * output: 
 * []
 * 
 * input: 37
 * output: 
 * []
 * input: 12
 * output:
 * [
 *  [2, 6],
 *  [2, 2, 3],
 *  [3, 4]
 * ]
 *
 * input: 32
 * output:
 * [
 *  [2, 16],
 *  [2, 2, 8],
 *  [2, 2, 2, 4],
 *  [2, 2, 2, 2, 2],
 *  [2, 4, 4],
 *  [4, 8]
 * ]
 * 
 * https://leetcode.com/problems/factor-combinations/description/
 */
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), 2, n);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> combination, int start, int n) {
        if (n <= 1) {
            if (combination.size() > 1) {
                result.add(new ArrayList<Integer>(combination));
            }
            return;
        }
        
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                combination.add(i);
                dfs(result, combination, i, n / i);
                combination.remove(combination.size() - 1);
            }
        }
    }
}