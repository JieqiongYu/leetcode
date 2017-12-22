public class Solution {
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0 ) {
      return 0;
    }

    int n = grid.length;
    int m = grid[0].length;
    int[][] dp = new int[n][m];

    // initialize
    dp[0][0] = 1;

    for (int i = 1; i < n; i++) {
      dp[i][0] =
    }
  }
}
