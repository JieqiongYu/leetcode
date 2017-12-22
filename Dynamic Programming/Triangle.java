/**
* Given a triangle, find the minimum path sum from top to bottom.
* Each step you may move to adjacent numbers on the row below.
*
* Notice
* Bonus point if you are able to do this using only O(n) extra space,
* where n is the total number of rows in the triangle.
*
* Example
* Given the following triangle:
*
* [
*     [2],
*    [3,4],
*   [6,5,7],
*  [4,1,8,3]
* ]
* The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*
* http://www.lintcode.com/en/problem/triangle/
*/
public class Solution {
  public int minimumTotal(int[][] triangle) {
    if (triangle == null || triangle.length == 0 || triangle[0] == null || triangle[0].length == 0) {
      return -1;
    }

    // state: f[x][y] = minimum path value from x,y to bottom
    int n = triangle.length;
    int[][] dp = new int[n][n];

    // initialize
    for (int i = 0; i < n; i++) {
      dp[n-1][i] = triangle[n-1][i];
    }

    // bottom up
    for (int i = n-2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
      }
    }

    return dp[0][0];
  }
}
