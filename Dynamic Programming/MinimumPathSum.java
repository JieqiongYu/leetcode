/**
* Given a m x n grid filled with non-negative numbers,
* find a path from top left to bottom right which minimizes the sum of
* all numbers along its path.
*
* Note: You can only move either down or right at any point in time.
*
* Example 1:
* [[1,3,1],
*  [1,5,1],
*  [4,2,1]]
*
* Given the above grid map, return 7.
* Because the path 1→3→1→1→1 minimizes the sum.
* 
* https://leetcode.com/problems/minimum-path-sum/description/
*/
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];

        dp[0][0] = grid[0][0];

        // initialize
        for (int i = 1; i < M; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int j = 1; j < N; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // funciton
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[M-1][N-1];
    }
}
