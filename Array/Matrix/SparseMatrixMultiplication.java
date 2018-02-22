/**
 * [LeetCode][311]Sparse Matrix Multiplication
 * 
 * Given two sparse matrices A and B, return the result of AB.
 * 
 * You may assume that A's column number is equal to B's row number.
 * 
 * Example:
 * 
 * A = [
 *   [ 1, 0, 0],
 *   [-1, 0, 3]
 * ]
 * 
 * B = [
 *   [ 7, 0, 0 ],
 *   [ 0, 0, 0 ],
 *   [ 0, 0, 1 ]
 * ]
 * 
 * 
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 * 
 * https://leetcode.com/problems/sparse-matrix-multiplication/description/
 */
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int k = B[0].length;
        
        int[][] result = new int[m][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int l = 0; l < k; l++) {
                        result[i][l] += A[i][j] * B[j][l];
                    }
                }
            }
        }
        
        return result;
    }
}