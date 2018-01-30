/**
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
 * http://www.jiuzhang.com/solution/combinations/
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        
        dfs(result, solution, n, k, 1);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> solution, int n, int k, int start) {
        if (solution.size() == k) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            solution.add(i);
            
            dfs(result, solution, n, k, i+1);
            solution.remove(solution.size() - 1);
        }
    }
}