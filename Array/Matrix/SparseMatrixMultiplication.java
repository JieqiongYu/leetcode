/**
 * [LeetCode][311] Sparse Matrix Multiplication
 * 
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 * 
 * Example:
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
        int rowA = A.length;
        int colA = A[0].length;
        int colB = B[0].length;
        
        int[][] result = new int[rowA][colB];
        
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colA; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < colB; k++) {
                        result[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        
        return result;
    }
}