/**
* A robot is located at the top-left corner of a m x n grid.
* The robot can only move either down or right at any point in time.
* The robot is trying to reach the bottom-right corner of the grid.
*
* How many possible unique paths are there?
*
* Notice
* m and n will be at most 100.
*
* http://www.lintcode.com/en/problem/unique-paths/
*/
public class Solution {
  public int uniquePaths(int m, int n) {
    if (m == 0 || n == 0) {
      return 1;
    }

    int[][] dp = new int[m][n];

    // initialize
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    for (int j = 0; j < n; j++) {
      dp[0][j] = 1;
    }

    // function
    for (int i = 1; i <  m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
      }
    }

    return dp[m-1][n-1];
  }
}
